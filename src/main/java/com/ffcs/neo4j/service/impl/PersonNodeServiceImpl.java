package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.repository.ImageNodeRepository;
import com.ffcs.neo4j.repository.PersonNodeRepository;
import com.ffcs.neo4j.service.ImageNodeService;
import com.ffcs.neo4j.service.PersonNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonNodeServiceImpl implements PersonNodeService {
    @Autowired
    PersonNodeRepository personNodeRepository;
    @Autowired
    ImageNodeService imageNodeServiceImpl;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public PersonNode add(PersonNode personNode) {
        if (personNode.getFeatureId() == null) {
            System.out.println("featureId不为空，添加失败！");
            return null;
        } else {
            if (!isExist(personNode)) {
                return personNodeRepository.save(personNode);
            } else {
                System.out.println("Person节点已存在！添加失败！");
                return this.findPersonNodeByFeatureId(personNode.getFeatureId());
            }
        }

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void addPersonNodeList(List<PersonNode> personNodeList) {
        for (PersonNode p : personNodeList) {
            if (isExist(p)) {
                personNodeRepository.save(p);
                System.out.println("添加Person节点成功！");
            } else {
                System.out.println("此节点已存在！添加失败！");
            }
        }
    }

    //DELETE
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deleteAll() {
        personNodeRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deletePerson(PersonNode personNode) {
        personNodeRepository.delete(personNode);
    }

    //UPDATE
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public PersonNode updatePersonNode(Long featureId, Long newFeatureId, String name) {
        PersonNode personNode = findPersonNodeByFeatureId(newFeatureId);
        if (personNode == null) {
            personNodeRepository.updatePersonNode(featureId, newFeatureId, name);
        } else {
            System.out.println("此featureID的Person节点已存在，不能修改！");
        }
        return personNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public PersonNode updateFeatureIdByFeatureId(Long featureId, Long newFeatureId) {
        PersonNode personNode = findPersonNodeByFeatureId(newFeatureId);
        if (personNode == null) {
            personNodeRepository.updateFeatureIdByFeatureId(featureId, newFeatureId);
        } else {
            System.out.println("此featureID的Person节点已存在，不能修改！");
        }
        return personNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public PersonNode updateNameByFeatureId(Long featureId, String name) {
        return personNodeRepository.updateNameByFeatureId(featureId, name);
    }

    //SEARCH
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public Iterable<PersonNode> findAll() {

        return personNodeRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public PersonNode findPersonNodeByFeatureId(Long featureId) {
        PersonNode personNode = personNodeRepository.findPersonNodeByFeatureId(featureId);
        if (personNode == null) {
            System.out.println("未找到此Person节点！");
        }
        return personNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public PersonNode findPersonNodeByImageFeatureId(Long featureId) {
        ImageNode imageNode = imageNodeServiceImpl.findImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            PersonNode personNode = personNodeRepository.findPersonNodeByImageNode(featureId);
            return personNode;
        } else {
            System.out.println("此图片节点不存在！");
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public boolean isExist(PersonNode personNode) {
        Iterable<PersonNode> personNodeList = personNodeRepository.findAll();
        for (PersonNode p : personNodeList) {
            if (p.getFeatureId().equals(personNode.getFeatureId())) {
                return true;
            }
        }
        return false;
    }
}
