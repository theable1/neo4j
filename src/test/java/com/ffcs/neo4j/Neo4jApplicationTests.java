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
            imageNode.setFeatureId(Long.valueOf(num));
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
        ImageNode imageNode = imageNodeServiceImpl.findImageNodeByFeatureId(55);
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
        System.out.println(imageNodeServiceImpl.updateSaveTimeByFeatureId(50,"2019-12-12"));
    }




}
