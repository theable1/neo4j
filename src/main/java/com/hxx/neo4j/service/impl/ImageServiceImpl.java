package com.hxx.neo4j.service.impl;


import com.hxx.neo4j.entity.ImageNode;
import com.hxx.neo4j.repository.ImageRepository;
import com.hxx.neo4j.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public ImageNode getImageNodeByFeatureId(String featureId) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        return imageNode;
    }

    @Override
    public void addImageNodeList(List<ImageNode> imageNodeList) {
        for (ImageNode imageNode : imageNodeList) {
            boolean isexist = this.isexist(imageNode);
            if (isexist == true) {
                System.out.println("该节点已存在！创建节点失败！");

            } else {
                ImageNode save = imageRepository.save(imageNode);
                System.out.println("创建节点成功");
            }
        }
    }

    @Override
    public boolean isexist(ImageNode imageNode) {
        String featureId = imageNode.getFeatureId();
        Iterable<ImageNode> imageNodes = this.findAll();
        for (ImageNode imageNode1 : imageNodes) {
            if (imageNode1.getFeatureId().equals(featureId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<ImageNode> findAll() {
        Iterable<ImageNode> imageNodes = imageRepository.findAll();
        return imageNodes;
    }

    @Override
    public void deleteAll() {
        imageRepository.deleteAll();
        ImageNode t = new ImageNode();
        imageRepository.delete(t);
    }

    @Override
    public ImageNode deleteImageNodeByFeatureId(String featureId) {

        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            imageRepository.delete(imageNode);
            System.out.println("已删除featureId = " + imageNode.getFeatureId() + "的节点！");
            return imageNode;
        } else {
            System.out.println("此节点不存在！删除失败！");
        }
        return null;
    }

    @Override
    public ImageNode updateImageNodeByFeatureId(String featureId, String imageId, String imageShowPath) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            imageRepository.updateImageNodeByFeatureId(featureId, imageId, imageShowPath);
            return imageNode;
        } else {
            System.out.println("此节点不存在！更新失败！");
        }
        return null;
    }

    @Override
    public ImageNode updateImageIdByFeatureId(String featureId, String imageId) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            imageRepository.updateImageIdByFeatureId(featureId, imageId);

            return imageNode;
        } else {
            System.out.println("此节点不存在！更新失败！");
        }
        return null;
    }

    @Override
    public ImageNode updateImageShowPathByFeatureId(String featureId, String imageShowPath) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            imageRepository.updateImageShowPathByFeatureId(featureId, imageShowPath);
            return imageNode;
        } else {
            System.out.println("此节点不存在！更新失败！");
        }
        return null;
    }
}
