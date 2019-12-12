package com.ffcs.neo4j.service;

//import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;

import java.util.List;

/**
 * @author hxx
 * @date 2019-12-11
 */
public interface OccurDateNodeService {
    /**
     * @param occurDateNode
     */
    void add(OccurDateNode occurDateNode);

    /**
     * 删除所有label=OccurDate的节点
     */
    void deleteAll();

    /**
     * 找出所有label=OccurDate的节点
     * @return Iterable<OccurDateNode>
     */
    Iterable<OccurDateNode> findAll();

    /**
     * 通过PersonNode得到最新日期节点
     * @param personNode
     * @return OccurDateNode
     */
    OccurDateNode getLatestOccurDateNodeByPersonNode(PersonNode personNode);

    /**
     * 通过ImageNode得到最新日期节点
     * @param imageNode
     * @return OccurDateNode
     */
//    OccurDateNode getLatestOccurDateNodeByImageNode(ImageNode imageNode);

    /**
     * 通过ImageNode得到相连的日期节点
     * @param imageNode
     * @return OccurDateNode
     */
//    OccurDateNode getOccurDateNodeByImageNode(ImageNode imageNode);

    /**
     * 获取下一个日期节点
     * @param occurDateNode
     * @return OccurDateNode
     */
    OccurDateNode getNextOccurDateNode(OccurDateNode occurDateNode);

    /**
     * 获取上一个日期节点
     * @param occurDateNode
     * @retur n OccurDateNode
     */
    OccurDateNode getPreviousOccurDateNode(OccurDateNode occurDateNode);

    /**
     * 获取PersonNode所有的日期节点
     * @param personNode
     * @return List<OccurDateNode>
     */
    List<OccurDateNode> getOccurDateListByPersonNode(PersonNode personNode);

    /**
     * 判断某个person节点下的某个日期节点是否存在
     * @param personNode
     * @param occurDateNode
     * @return boolean
     */
    boolean isExist(PersonNode personNode,OccurDateNode occurDateNode);
}
