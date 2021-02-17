package com.mytest.ptmanager.wrapper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ZkClient {

    private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);

    @Autowired
    @Qualifier("curatorClient")
    private CuratorFramework client;

    @PostConstruct
    public void init(){
        if (!isExistNode("/pt/qps")){
            createNode(CreateMode.PERSISTENT, "/pt/qps", "{}");
        } else {
            //启动时QPS重置为0
            modifyNodeData("/pt/qps", "{}".getBytes());
        }
    }


    /**
     * 设置指定节点的数据
     * @param path
     * @param datas
     */
    public void modifyNodeData(String path, byte[] datas){
        try {
            client.setData().forPath(path, datas);
        }catch (Exception ex) {
            logger.error("{}",ex);
        }
    }

    /**
     * 创建节点
     * @param mode       节点类型
     * 1、PERSISTENT 持久化目录节点，存储的数据不会丢失。
     * 2、PERSISTENT_SEQUENTIAL顺序自动编号的持久化目录节点，存储的数据不会丢失
     * 3、EPHEMERAL临时目录节点，一旦创建这个节点的客户端与服务器端口也就是session 超时，这种节点会被自动删除
     *4、EPHEMERAL_SEQUENTIAL临时自动编号节点，一旦创建这个节点的客户端与服务器端口也就是session 超时，这种节点会被自动删除，并且根据当前已近存在的节点数自动加 1，然后返回给客户端已经成功创建的目录节点名。
     * @param path  节点名称
     * @param nodeData  节点数据
     */
    private void createNode(CreateMode mode, String path, String nodeData) {
        try {
            //使用creatingParentContainersIfNeeded()之后Curator能够自动递归创建所有所需的父节点
            client.create().creatingParentsIfNeeded().withMode(mode).forPath(path,nodeData.getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("注册出错", e);
        }
    }

    /**
     * 判断路径是否存在
     *
     * @param path
     * @return
     */
    private boolean isExistNode(final String path) {
        client.sync();
        try {
            return null != client.checkExists().forPath(path);
        } catch (Exception ex) {
            return false;
        }
    }
//
//    /**
//     * 删除节点数据
//     *
//     * @param path
//     */
//    private void deleteNode(final String path) {
//        try {
//            deleteNode(path,true);
//        } catch (Exception ex) {
//            logger.error("{}",ex);
//        }
//    }
//
//
//    /**
//     * 删除节点数据
//     * @param path
//     * @param deleteChildren   是否删除子节点
//     */
//    private void deleteNode(final String path, Boolean deleteChildren){
//        try {
//            if(deleteChildren){
//                //guaranteed()删除一个节点，强制保证删除,
//                // 只要客户端会话有效，那么Curator会在后台持续进行删除操作，直到删除节点成功
//                client.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
//            }else{
//                client.delete().guaranteed().forPath(path);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    /**
//     * 获取指定节点的数据
//     * @param path
//     * @return
//     */
//    private byte[] getNodeData(String path){
//        Byte[] bytes = null;
//        try {
//            client.getData().forPath(path);
//            return client.getData().forPath(path);
//        }catch (Exception ex) {
//            logger.error("{}",ex);
//        }
//        return null;
//    }
//
//    /**
//     * 获取数据时先同步
//     * @param path
//     * @return
//     */
//    private byte[] synNodeData(String path){
//        client.sync();
//        return getNodeData( path);
//    }


//    /**
//     * 获取节点的子节点
//     * @param path
//     * @return
//     */
//    public List<String> getChildren(String path) {
//        List<String> childrenList = new ArrayList<>();
//        try {
//            childrenList = client.getChildren().forPath(path);
//        } catch (Exception e) {
//            logger.error("获取子节点出错", e);
//        }
//        return childrenList;
//    }

//    /**
//     * 创建节点
//     * @param mode       节点类型
//     *                   1、PERSISTENT 持久化目录节点，存储的数据不会丢失。
//     *                   2、PERSISTENT_SEQUENTIAL顺序自动编号的持久化目录节点，存储的数据不会丢失
//     *                   3、EPHEMERAL临时目录节点，一旦创建这个节点的客户端与服务器端口也就是session 超时，这种节点会被自动删除
//     *                   4、EPHEMERAL_SEQUENTIAL临时自动编号节点，一旦创建这个节点的客户端与服务器端口也就是session 超时，这种节点会被自动删除，并且根据当前已近存在的节点数自动加 1，然后返回给客户端已经成功创建的目录节点名。
//     * @param path  节点名称
//     */
//    public void createNode(CreateMode mode, String path) {
//        try {
//            //使用creatingParentContainersIfNeeded()之后Curator能够自动递归创建所有所需的父节点
//            client.create().creatingParentsIfNeeded().withMode(mode).forPath(path);
//        } catch (Exception e) {
//            logger.error("注册出错", e);
//        }
//    }
}
