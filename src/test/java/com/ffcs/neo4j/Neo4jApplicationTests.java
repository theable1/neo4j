package com.ffcs.neo4j;


import com.ffcs.neo4j.entity.HangRelationship;
//import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.NextRelationship;
import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.service.*;
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
    OccurDateNodeService occurDateNodeService;
    @Autowired
    PersonNodeService personNodeService;
    @Autowired
    HangRelationshipService hangRelationshipService;
    @Autowired
    LatestRelationshipService latestRelationshipService;
    @Autowired
    NextRelationshipService nextRelationshipService;

    @Test
    void contextLoads() {
    }

//    @Test
//    void addIamgeNodes() {
//        List<ImageNode> imageNodeList = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Random random = new Random();
//            int num = random.nextInt(100);
//            ImageNode imageNode = new ImageNode();
//            imageNode.setFeatureId(String.valueOf(num));
//            imageNodeList.add(imageNode);
//        }
//        imageNodeServiceImpl.addImageNodeList(imageNodeList);
//    }
//
//    @Test
//    void deleteAll() {
//        imageNodeServiceImpl.deleteAll();
//    }
//
//    @Test
//    void getImageNodeByFeatureId() {
//        imageNodeServiceImpl.getImageNodeByFeatureId("123");
//    }
//
//    @Test
//    void findAllImageNode() {
//        Iterable<ImageNode> imageNodes = imageNodeServiceImpl.findAll();
//        System.out.println(imageNodes.toString());
//    }
//
//    @Test
//    void isExist() {
//        ImageNode imageNode = new ImageNode();
//        imageNode.setFeatureId("111");
//        imageNode.setImageShowPath("xxx123.jpg");
//        imageNode.setImageId("123");
//        boolean isexist = imageNodeServiceImpl.isExist(imageNode);
//        System.out.println(isexist);
//    }

//    @Test
//    void dateImageNode() {
//        System.out.println(imageNodeServiceImpl.updateImageNodeByFeatureId("260", "111", "xxx111.jpg"));
//        System.out.println(imageNodeServiceImpl.updateImageIdByFeatureId("260", "222"));
//        System.out.println(imageNodeServiceImpl.updateImageShowPathByFeatureId("260", "xxx222.jpg"));
//    }

//    @Test
//    void dateIsExistTest(){
//        for (int i = 0; i < 5 ; i++) {
//            ImageNode imageNode = new ImageNode();
//            imageNode.setFeatureId(String.valueOf(i));
//            imageNodeServiceImpl.add(imageNode);
//            HangRelationship hangRelationship = new HangRelationship();
//            hangRelationship.setImageNode();
//            hangRelationship.setOccurDateNode();
//            hangRelationshipService.add();
//        }
//    }

    @Test
    void getLatestDateTest() {
        PersonNode personNode = new PersonNode();
        personNode.setFeatureId((long) 1);
        OccurDateNode node = occurDateNodeService.getLatestOccurDateNodeByPersonNode(personNode);
        System.out.println(node);
    }

    @Test
    void getPreviousAndNextDateTest() {
        PersonNode personNode = new PersonNode();
        personNode.setFeatureId((long) 1);
        OccurDateNode node = occurDateNodeService.getLatestOccurDateNodeByPersonNode(personNode);
        OccurDateNode previousOccurDateNode = occurDateNodeService.getPreviousOccurDateNode(node);
        System.out.println(node.getDate() + "的前一个时间节点" + previousOccurDateNode.getDate());
        OccurDateNode nextOccurDateNode = occurDateNodeService.getNextOccurDateNode(previousOccurDateNode);
        System.out.println(previousOccurDateNode.getDate() + "的后一个时间节点" + nextOccurDateNode.getDate());
    }

    @Test
    void getDateListTest() {
        PersonNode personNode = new PersonNode();
        personNode.setFeatureId((long) 1);
        List<OccurDateNode> list = occurDateNodeService.getOccurDateListByPersonNode(personNode);
        for (OccurDateNode occurDateNode : list) {
            System.out.println(occurDateNode);
        }
    }

    @Test
    void dateNodeIsExistTest() {
        PersonNode personNode = new PersonNode();
        personNode.setFeatureId((long) 1);
        OccurDateNode occurDateNode = new OccurDateNode();
        occurDateNode.setDate("2019");
        List<OccurDateNode> list = occurDateNodeService.getOccurDateListByPersonNode(personNode);
        for (OccurDateNode node : list) {
            System.out.println(node);
        }
    }

    @Test
    void addLatestDate() {
        PersonNode personNode = new PersonNode();
        personNode.setFeatureId((long) 2);
        OccurDateNode occurDateNode = new OccurDateNode();
        occurDateNode.setDate("2019-11-23");
        OccurDateNode dateNode = occurDateNodeService.add(personNode, occurDateNode);
        System.out.println(dateNode);
    }

    @Test
    void deleteRelationTest() {
        OccurDateNode start = new OccurDateNode();
        OccurDateNode end = new OccurDateNode();
        start.setId((long) 20);
        end.setId((long) 1);
        System.out.println("end:" + end);
        System.out.println("start:" + start);
        NextRelationship nextRelationship = new NextRelationship();
        nextRelationship.setStartDateNode(start);
        nextRelationship.setEndDateNode(end);
        nextRelationshipService.deleteNextRelationship(nextRelationship);
    }

    @Test
    void addRelationTest() {
        OccurDateNode start = new OccurDateNode();
        OccurDateNode end = new OccurDateNode();
        start.setId((long) 20);
        start.setDate("2019-12-11");
        end.setId((long) 1);
        end.setDate("2019-12-12");
        System.out.println("end:" + end);
        System.out.println("start:" + start);
        NextRelationship nextRelationship = new NextRelationship();
        nextRelationship.setStartDateNode(start);
        nextRelationship.setEndDateNode(end);
        nextRelationshipService.add(nextRelationship);
    }

    @Test
    void getDateNode() {
        PersonNode personNode = new PersonNode();
        personNode.setFeatureId((long) 1);
        String date = "2019-12-11";
        OccurDateNode node = occurDateNodeService.getOccurDateNodeByPersonNode(personNode, date);
        System.out.println(node);
    }

}
