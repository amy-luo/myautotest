package com.mytest.ptworker.base.wrapper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ZkClient {

    private static final Logger logger = LoggerFactory.getLogger(ZkClient.class);

    @Autowired
    @Qualifier("curatorClient")
    private CuratorFramework client;

    /**
     * 监听数据节点的变化情况
     * @param watchPath
     * @param listener
     */
    public NodeCache watchPath(String watchPath, NodeCacheListener listener){
        NodeCache cache = new NodeCache(client, watchPath, false);
        cache.getListenable().addListener(listener);
        try {
            cache.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cache;
    }

    /**
     * 获取指定节点的数据
     * @param path
     * @return
     */
    private byte[] getNodeData(String path){
        Byte[] bytes = null;
        try {
            client.getData().forPath(path);
            return client.getData().forPath(path);
        }catch (Exception ex) {
            logger.error("{}",ex);
        }
        return null;
    }
}
