package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.repository.ImageNodeRepository;
import com.ffcs.neo4j.service.ImageNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageNodeServiceImpl implements ImageNodeService {
    @Autowired
    ImageNodeRepository imageRepository;

    @Override
    public void add(ImageNode imageNode) {
        if (!isExist(imageNode)) {
            imageRepository.save(imageNode);
            System.out.println("创建节点成功");
        } else {
            System.out.println("该节点已存在！创建节点失败！");
        }
    }

    @Override
    public void addImageNodeList(List<ImageNode> imageNodeList) {
        for (ImageNode imageNode : imageNodeList) {
            if (isExist(imageNode)) {
                System.out.println("该节点已存在！创建节点失败！");
            } else {
                ImageNode save = imageRepository.save(imageNode);
                System.out.println("创建节点成功");
            }
        }
    }

    @Override
    public ImageNode getImageNodeByFeatureId(String featureId) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        return imageNode;
    }

    @Override
    public void deleteAll() {
        imageRepository.deleteAll();
        System.out.println("已删除所有节点及关系");
    }

    @Override
    public void deleteImageNodeByFeatureId(String featureId) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            imageRepository.delete(imageNode);
            System.out.println("已删除featureId = " + imageNode.getFeatureId() + "的节点！");
        } else {
            System.out.println("此节点不存在！删除失败！");
        }
    }

    @Override
    public ImageNode updateImageNodeByFeatureId(String featureId, String imageId, String imageShowPath) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            ImageNode node = imageRepository.updateImageNodeByFeatureId(featureId, imageId, imageShowPath);
            return node;
        } else {
            System.out.println("此节点不存在！更新失败！");
        }
        return null;
    }

    @Override
    public ImageNode updateImageIdByFeatureId(String featureId, String imageId) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            ImageNode node = imageRepository.updateImageIdByFeatureId(featureId, imageId);
            return node;
        } else {
            System.out.println("此节点不存在！更新失败！");
        }
        return null;
    }

    @Override
    public ImageNode updateImageShowPathByFeatureId(String featureId, String imageShowPath) {
        ImageNode imageNode = imageRepository.getImageNodeByFeatureId(featureId);
        if (imageNode != null) {
            ImageNode node = imageRepository.updateImageShowPathByFeatureId(featureId, imageShowPath);
            return node;
        } else {
            System.out.println("此节点不存在！更新失败！");
        }
        return null;
    }

    @Override
    public Iterable<ImageNode> findAll() {
        Iterable<ImageNode> imageNodes = imageRepository.findAll();
        return imageNodes;
    }

    @Override
    public boolean isExist(ImageNode imageNode) {
        String featureId = imageNode.getFeatureId();
        Iterable<ImageNode> imageNodes = this.findAll();
        for (ImageNode node : imageNodes) {
            if (node.getFeatureId().equals(featureId)) {
                return true;
            }
        }
        return false;
    }

}
