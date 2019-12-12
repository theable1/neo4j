package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.repository.OccurDateNodeRepository;
import com.ffcs.neo4j.service.OccurDateNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OccurDateNodeServiceImpl implements OccurDateNodeService {
    @Autowired
    OccurDateNodeRepository occurDateNodeRepository;

    @Override
    public void add(OccurDateNode occurDateNode) {
        if (!isExist(occurDateNode)) {
            occurDateNodeRepository.save(occurDateNode);
            System.out.println("创建节点成功");
        } else {
            System.out.println("该节点已存在！创建节点失败！");
        }
    }

    @Override
    public void addOccurDateNodeList(List<OccurDateNode> occurDateNodeList) {
        for (OccurDateNode occurDateNode : occurDateNodeList) {
            if (isExist(occurDateNode)) {
                System.out.println("该节点已存在！创建节点失败！");
            } else {
                occurDateNodeRepository.save(occurDateNode);
                System.out.println("创建节点成功");
            }
        }
    }

    @Override
    public OccurDateNode getOccurDateNodeByDate(String date) {
        OccurDateNode occurDateNode = occurDateNodeRepository.getOccurDateNodeByDate(date);
        return occurDateNode;
    }

    @Override
    public void deleteAll() {
        occurDateNodeRepository.deleteAll();
        System.out.println("已删除所有节点及关系");
    }

    @Override
    public void deleteOccurDateNodeByDate(String date) {
        OccurDateNode occurDateNode = occurDateNodeRepository.getOccurDateNodeByDate(date);
        if (occurDateNode != null) {
            occurDateNodeRepository.delete(occurDateNode);
            System.out.println("已删除date = " + occurDateNode.getDate() + "的节点！");
        } else {
            System.out.println("此节点不存在！删除失败！");
        }
    }

    @Override
    public OccurDateNode updateOccurDateNodeByDate(String date) {
        return null;
    }

    @Override
    public Iterable<OccurDateNode> findAll() {
        Iterable<OccurDateNode> occurDateNodes = occurDateNodeRepository.findAll();
        return occurDateNodes;
    }

    @Override
    public boolean isExist(OccurDateNode occurDateNode) {
        return false;
    }

}
