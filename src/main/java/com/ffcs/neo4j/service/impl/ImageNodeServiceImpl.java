package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.repository.ImageNodeRepository;
import com.ffcs.neo4j.service.ImageNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageNodeServiceImpl implements ImageNodeService {
    @Autowired
    ImageNodeRepository imageNodeRepository;

    //CREATE
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public ImageNode add(ImageNode imageNode) {
        if (imageNode.getFeatureId() == null) {
            System.out.println("fetureId不能为空，添加失败！");
            return null;
        } else {
            if (!isExist(imageNode)) {
                System.out.println("添加Image成功！");
                return imageNodeRepository.save(imageNode);
            } else {
                System.out.println("此Image节点已存在！添加失败！！");
                return this.findImageNodeByFeatureId(imageNode.getFeatureId());
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public void addList(List<ImageNode> imageNodeList) {
        for (ImageNode i : imageNodeList) {
            boolean isExist = isExist(i);
            if (isExist == false) {
                imageNodeRepository.save(i);
                System.out.println("添加成功！");
            } else {
                System.out.println("此图片节点已存在！添加失败！");
            }
        }
    }

    //DELETE
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public void deleteAll() {
        imageNodeRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public void delete(ImageNode imageNode) {
        imageNodeRepository.delete(imageNode);
    }

    //UPDATE
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public ImageNode updateImageNode(Long featureId, String imageId, String imageUrl, String saveTime) {
        ImageNode imageNode = imageNodeRepository.updateImageNode(featureId, imageId, imageUrl, saveTime);
        return imageNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public ImageNode updateImageIdByFeatureId(Long featureId, String imageId) {
        ImageNode imageNode = imageNodeRepository.updateImageIdByFeatureId(featureId, imageId);
        return imageNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public ImageNode updateImageUrlByFeatureId(Long featureId, String imageUrl) {
        ImageNode imageNode = imageNodeRepository.updateImageUrlByFeatureId(featureId, imageUrl);
        return imageNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public ImageNode updateSaveTimeByFeatureId(Long featureId, String saveTime) {
        ImageNode imageNode = imageNodeRepository.updateSaveTimeByFeatureId(featureId, saveTime);
        return imageNode;
    }

    //SEARCH
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public Iterable<ImageNode> findAll() {
        Iterable<ImageNode> imageNodes = imageNodeRepository.findAll();
        return imageNodes;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public ImageNode findImageNodeByFeatureId(Long featureId) {
        ImageNode imageNode = imageNodeRepository.findImageNodeByFeatureId(featureId);
        if (imageNode == null) {
            System.out.println("该图片节点不存在");
        }
        return imageNode;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true,rollbackFor = Throwable.class)
    public Boolean isExist(ImageNode imageNode) {
        Iterable<ImageNode> imageNodeList = findAll();
        for (ImageNode i : imageNodeList) {
            if (i.getFeatureId().equals(imageNode.getFeatureId())) {
                return true;
            }
        }
        return false;
    }
}
