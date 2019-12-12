package com.ffcs.neo4j;


import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.service.ImageNodeService;
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
            imageNode.setFeatureId(String.valueOf(num));
            imageNodeList.add(imageNode);
        }
        imageNodeServiceImpl.addImageNodeList(imageNodeList);
    }

    @Test
    void deleteAll() {
        imageNodeServiceImpl.deleteAll();
    }

    @Test
    void getImageNodeByFeatureId() {
        imageNodeServiceImpl.getImageNodeByFeatureId("123");
    }

    @Test
    void findAllImageNode() {
        Iterable<ImageNode> imageNodes = imageNodeServiceImpl.findAll();
        System.out.println(imageNodes.toString());
    }

    @Test
    void isExist() {
        ImageNode imageNode = new ImageNode();
        imageNode.setFeatureId("111");
        imageNode.setImageShowPath("xxx123.jpg");
        imageNode.setImageId("123");
        boolean isexist = imageNodeServiceImpl.isExist(imageNode);
        System.out.println(isexist);
    }

//    @Test
//    void dateImageNode() {
//        System.out.println(imageNodeServiceImpl.updateImageNodeByFeatureId("260", "111", "xxx111.jpg"));
//        System.out.println(imageNodeServiceImpl.updateImageIdByFeatureId("260", "222"));
//        System.out.println(imageNodeServiceImpl.updateImageShowPathByFeatureId("260", "xxx222.jpg"));
//    }



}