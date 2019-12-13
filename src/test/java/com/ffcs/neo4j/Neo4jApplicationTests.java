package com.ffcs.neo4j;


import com.ffcs.neo4j.entity.HangRelationship;
import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.service.HangRelationshipService;
import com.ffcs.neo4j.service.ImageNodeService;
import com.ffcs.neo4j.service.OccurDateNodeService;
import com.ffcs.neo4j.service.PersonNodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class Neo4jApplicationTests {
    @Autowired
    ImageNodeService imageNodeServiceImpl;
    @Autowired
    OccurDateNodeService occurDateNodeServiceImpl;
    @Autowired
    PersonNodeService personNodeServiceImpl;
    @Autowired
    HangRelationshipService hangRelationshipServiceImpl;

    @Test
    void contextLoads() {
    }

    @Test
    void addIamgeNodes() {
        List<ImageNode> imageNodeList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            int num = random.nextInt(100);
            ImageNode imageNode = new ImageNode();
//            imageNode.setFeatureId(Long.valueOf(num));
            imageNodeList.add(imageNode);
        }
        imageNodeServiceImpl.addList(imageNodeList);
    }

    @Test
    void deleteAll() {
        imageNodeServiceImpl.deleteAll();
    }

    @Test
    void findImageNodeByFeatureId() {
        ImageNode imageNode = imageNodeServiceImpl.findImageNodeByFeatureId(Long.valueOf(20));
        System.out.println(imageNode);
    }

    @Test
    void findAllImageNode() {
        Iterable<ImageNode> imageNodes = imageNodeServiceImpl.findAll();
        System.out.println(imageNodes.toString());
    }

    @Test
    void isExist() {
        ImageNode imageNode = new ImageNode();
        imageNode.setFeatureId(Long.valueOf(500));
        imageNode.setImageUrl("xxx123.jpg");
        imageNode.setImageId("123");
        boolean isexist = imageNodeServiceImpl.isExist(imageNode);
        System.out.println(isexist);
    }

    @Test
    void dateImageNode() {
//        System.out.println(imageNodeServiceImpl.updateImageNode(50, "222", "xxx222.jpg","2019-12-11"));
//        System.out.println(imageNodeServiceImpl.updateImageIdByFeatureId(50, "333"));
//        System.out.println(imageNodeServiceImpl.updateImageUrlByFeatureId(50, "333.jpg"));
        System.out.println(imageNodeServiceImpl.updateSaveTimeByFeatureId(Long.valueOf(50),"2019-12-12"));
    }
    @Test
    void test(){
//        OccurDateNode occurDateNode =new OccurDateNode();
//        occurDateNode.setDate("2016-12-11");
        PersonNode personNode = personNodeServiceImpl.findPersonNodeByFeatureId(Long.valueOf(111));
//        System.out.println(personNode);
//        occurDateNodeServiceImpl.add(personNode,occurDateNode);
        OccurDateNode occurDateNode = occurDateNodeServiceImpl.getOccurDateNodeByPersonNode(personNode, "2016-12-11");
        System.out.println("occurDateNode:"+occurDateNode);
        ImageNode imageNode = imageNodeServiceImpl.findImageNodeByFeatureId(Long.valueOf(6));
        HangRelationship hangRelationship = new HangRelationship();
        hangRelationship.setOccurDateNode(occurDateNode);
        hangRelationship.setImageNode(imageNode);
        hangRelationshipServiceImpl.add(hangRelationship);
//        hangRelationship.setOccurDateNode();
//        hangRelationshipServiceImpl.add();

    }
    @Test
    void add(){
//        ImageNode imageNode =new ImageNode();
//        imageNode.setFeatureId(Long.valueOf(6));
//        System.out.println(imageNodeServiceImpl.add(imageNode));
        PersonNode personNode =new PersonNode();
        personNode.setFeatureId(Long.valueOf(111));
        System.out.println(personNodeServiceImpl.add(personNode));
        OccurDateNode occurDateNode = occurDateNodeServiceImpl.getOccurDateNodeByPersonNode(personNode, "2016-12-11");
        List<ImageNode> imageNodes = imageNodeServiceImpl.findAllByOccurDate(occurDateNode.getId());
        for (ImageNode imageNode : imageNodes) {
            System.out.println(imageNode);
        }

    }




}
