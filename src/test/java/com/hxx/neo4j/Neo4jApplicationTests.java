package com.hxx.neo4j;


import com.hxx.neo4j.entity.*;
import com.hxx.neo4j.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class Neo4jApplicationTests {
    @Autowired
    ImageService imageServiceImpl;
    @Autowired
    ImageRelationService imageRelationServiceImpl;
    @Test
    void contextLoads() {
    }
    @Test
    void addIamgeNode(){
        List<ImageNode> imageNodeList = new ArrayList<>();
        for(int i=0;i<100;i++){
            Random random = new Random();
            int num = random.nextInt(100);
            ImageNode imageNode = new ImageNode();
            imageNode.setFeatureId(String.valueOf(num));
            imageNodeList.add(imageNode);
        }
        imageServiceImpl.addImageNodeList(imageNodeList);
    }
    @Test
    void deleteAll(){
        imageServiceImpl.deleteAll();
    }
    @Test
    void deleteByFeatureId(){
        ImageNode imageNode = imageServiceImpl.deleteImageNodeByFeatureId("88");
        System.out.println(imageNode);
    }
    @Test
    void getImageNodeByFeatureId(){
        imageServiceImpl.getImageNodeByFeatureId("123");
    }
    @Test
    void findAllImageNode(){
        Iterable<ImageNode> imageNodes = imageServiceImpl.findAll();
        System.out.println(imageNodes.toString());
    }
    @Test
    void isExist(){
        ImageNode imageNode = new ImageNode();
        imageNode.setFeatureId("111");
        imageNode.setImageShowPath("xxx123.jpg");
        imageNode.setImageId("123");
        boolean isexist = imageServiceImpl.isexist(imageNode);
        System.out.println(isexist);
    }
    @Test
    void addIamgeRelation(){
        ImageNode node1 = imageServiceImpl.getImageNodeByFeatureId("123");
        ImageNode node2= imageServiceImpl.getImageNodeByFeatureId("111");
        HangRelation hangRelation =new HangRelation();
        hangRelation.setStartNode(node1);
        hangRelation.setEndNode(node2);
        hangRelation.setDistance(0.7);
        imageRelationServiceImpl.addImageRelation(hangRelation);

    }
    @Test
    void dateImageNode(){
        System.out.println(imageServiceImpl.updateImageNodeByFeatureId("260","111","xxx111.jpg"));
        System.out.println(imageServiceImpl.updateImageIdByFeatureId("260","222"));
        System.out.println(imageServiceImpl.updateImageShowPathByFeatureId("260", "xxx222.jpg"));
    }


}
