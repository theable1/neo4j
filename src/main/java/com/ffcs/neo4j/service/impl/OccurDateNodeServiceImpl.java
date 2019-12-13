package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.*;
import com.ffcs.neo4j.repository.LatestRelationshipRepository;
import com.ffcs.neo4j.repository.NextRelationshipRepository;
import com.ffcs.neo4j.repository.OccurDateNodeRepository;
import com.ffcs.neo4j.repository.PersonNodeRepository;
import com.ffcs.neo4j.service.OccurDateNodeService;
import com.ffcs.neo4j.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OccurDateNodeServiceImpl implements OccurDateNodeService {
    @Autowired
    OccurDateNodeRepository occurDateNodeRepository;
    @Autowired
    LatestRelationshipRepository latestRelationshipRepository;
    @Autowired
    NextRelationshipRepository nextRelationshipRepository;
    @Autowired
    PersonNodeRepository personNodeRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public OccurDateNode add(PersonNode person, OccurDateNode occurDateNode) {
        OccurDateNode dateNode = null;
        //防止person节点id为null，无法添加删除相关关系
        PersonNode personNode = person;
        if (person.getId() == null) {
            personNode = personNodeRepository.findPersonNodeByFeatureId(person.getFeatureId());
        }
        if (!this.isExist(personNode, occurDateNode)) {
            dateNode = occurDateNodeRepository.save(occurDateNode);
            OccurDateNode latestDateNode = this.getLatestOccurDateNodeByPersonNode(personNode);
            List<OccurDateNode> list = this.getOccurDateListByPersonNode(personNode);
            //person节点存在相关的日期节点
            if (list.size() != 0) {
                OccurDateNode minDateNode = list.get(list.size() - 1);
                Date latest = null;
                Date newDate = null;
                Date minDate = null;
                try {
                    latest = DateUtils.strToDate(latestDateNode.getDate());
                    newDate = DateUtils.strToDate(occurDateNode.getDate());
                    minDate = DateUtils.strToDate(minDateNode.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (latest.before(newDate)) {
                    //新添加的时间在目前的最新时间之后
                    //1、删除原本的LATEST关系
                    latestRelationshipRepository.deleteLatestRelationship(latestDateNode.getId(), personNode.getId());
                    //2、原本的最新时间节点指向新添时间节点
                    NextRelationship nextRelationship = new NextRelationship();
                    nextRelationship.setStartDateNode(latestDateNode);
                    nextRelationship.setEndDateNode(dateNode);
                    nextRelationshipRepository.save(nextRelationship);
                    //3、新时间节点指向Person节点
                    LatestRelationship latestRelationship = new LatestRelationship();
                    latestRelationship.setPersonNode(personNode);
                    latestRelationship.setOccurDateNode(dateNode);
                    latestRelationshipRepository.save(latestRelationship);
                    System.out.println(dateNode + "日期节点为最新日期");
                } else if (minDate.after(newDate)) {
                    //新添日期在最早日期之前
                    //新添时间节点指向原本的最早日期节点
                    NextRelationship nextRelationship = new NextRelationship();
                    nextRelationship.setStartDateNode(dateNode);
                    nextRelationship.setEndDateNode(minDateNode);
                    nextRelationshipRepository.save(nextRelationship);
                    System.out.println(dateNode + "日期节点为最小日期");
                } else {
                    //新添加的时间插入时间节点之间
                    //1、遍历person节点的所有日期节点,比较日期，找出新添日期节点的前后日期节点
                    OccurDateNode nextNode = null;
                    OccurDateNode previousNode = null;
                    //list的时间节点是从大到小排序
                    for (int i = 0; i < list.size(); i++) {
                        Date date = null;
                        try {
                            date = DateUtils.strToDate(list.get(i).getDate());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (date.before(newDate)) {
                            previousNode = list.get(i);
                            nextNode = list.get(i - 1);
                            break;
                        }
                    }
                    //3、删除前后日期节点的next关系
                    nextRelationshipRepository.deleteNextRelationship(previousNode.getId(), nextNode.getId());
                    //4、新建新添节点和前后节点的关系
                    NextRelationship nextRelationship1 = new NextRelationship();
                    nextRelationship1.setStartDateNode(previousNode);
                    nextRelationship1.setEndDateNode(dateNode);
                    nextRelationshipRepository.save(nextRelationship1);
                    NextRelationship nextRelationship2 = new NextRelationship();
                    nextRelationship2.setStartDateNode(dateNode);
                    nextRelationship2.setEndDateNode(nextNode);
                    nextRelationshipRepository.save(nextRelationship2);
                    System.out.println(dateNode + "日期节点插入到" + previousNode + "节点和" + nextNode + "节点之间");
                }
            } else {
                //person节点不存在日期节点
                //新添日期节点连向person节点
                LatestRelationship latestRelationship = new LatestRelationship();
                latestRelationship.setPersonNode(personNode);
                latestRelationship.setOccurDateNode(dateNode);
                latestRelationshipRepository.save(latestRelationship);
                System.out.println(dateNode + "日期节点为最新日期");
            }
        } else {
            dateNode = this.getOccurDateNodeByPersonNode(personNode, occurDateNode.getDate());
            System.out.println(occurDateNode.getDate() + "日期节点已存在！已返回该节点");
        }
        return dateNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deleteAll() {
        occurDateNodeRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public Iterable<OccurDateNode> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public OccurDateNode getLatestOccurDateNodeByPersonNode(PersonNode personNode) {
        OccurDateNode latestOccurDateNode = occurDateNodeRepository.getLatestOccurDateNodeByPersonNode(personNode.getFeatureId());
        return latestOccurDateNode;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public OccurDateNode getOccurDateNodeByPersonNode(PersonNode personNode, String date) {
        OccurDateNode node = occurDateNodeRepository.getOccurDateNodeByPersonNode(personNode.getFeatureId(), date);
        return node;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public OccurDateNode getNextOccurDateNode(OccurDateNode occurDateNode) {
        OccurDateNode nextOccurDateNode = occurDateNodeRepository.getNextOccurDateNode(occurDateNode.getId());
        return nextOccurDateNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public OccurDateNode getPreviousOccurDateNode(OccurDateNode occurDateNode) {
        OccurDateNode previousOccurDateNode = occurDateNodeRepository.getPreviousOccurDateNode(occurDateNode.getId());
        return previousOccurDateNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public List<OccurDateNode> getOccurDateListByPersonNode(PersonNode personNode) {
        OccurDateNode latestDate = this.getLatestOccurDateNodeByPersonNode(personNode);
        List<OccurDateNode> list = new ArrayList<>();
        if (latestDate != null) {
            list.add(latestDate);
            OccurDateNode previousOccurDateNode = this.getPreviousOccurDateNode(latestDate);
            while (previousOccurDateNode != null) {
                list.add(previousOccurDateNode);
                previousOccurDateNode = this.getPreviousOccurDateNode(previousOccurDateNode);
            }
        }
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public boolean isExist(PersonNode personNode, OccurDateNode occurDateNode) {
        List<OccurDateNode> list = this.getOccurDateListByPersonNode(personNode);
        for (OccurDateNode dateNode : list) {
            if (dateNode.getDate().equals(occurDateNode.getDate())) {
                return true;
            }
        }
        return false;
    }
}
