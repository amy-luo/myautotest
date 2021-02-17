package com.mytest.ptmanager.configure;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ZkConfig {

    private static final Logger logger = LoggerFactory.getLogger(ZkConfig.class);

    @Value("zk.base.sleep.time.ms")
    private Integer baseSleepTimeMs;

    @Value("zk.max.retries")
    private Integer maxRetries;

    @Value("zk.server")
    private String zkServer;

    @Value("zk.session.timeout.ms")
    private Integer zkSessionTimeoutMs;

    @Value("zk.connection.timeout.ms")
    private Integer zkConnectionTimeoutMs;

    @Value("zk.namespace")
    private String zkNamespace;

    @Value("zk.digest")
    private String zkDigest;

    private CuratorFramework client;

    @Bean("curatorClient")
    public CuratorFramework CuratorClient() {
        try{
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(baseSleepTimeMs, maxRetries);
            CuratorFrameworkFactory.Builder builder   = CuratorFrameworkFactory.builder()
                    .connectString(zkServer).retryPolicy(retryPolicy)
                    .sessionTimeoutMs(zkSessionTimeoutMs)
                    .connectionTimeoutMs(zkConnectionTimeoutMs)
                    .namespace(zkNamespace);
            if(StringUtils.isNotEmpty(zkDigest)){
                builder.authorization("digest", zkDigest.getBytes("UTF-8"));
                builder.aclProvider(new ACLProvider() {
                    @Override
                    public List<ACL> getDefaultAcl() {
                        return ZooDefs.Ids.CREATOR_ALL_ACL;
                    }

                    @Override
                    public List<ACL> getAclForPath(final String path) {
                        return ZooDefs.Ids.CREATOR_ALL_ACL;
                    }
                });
            }
            client = builder.build();
            client.start();

            client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
                public void stateChanged(CuratorFramework client, ConnectionState state) {
                    if (state == ConnectionState.LOST) {
                        //连接丢失
                        logger.info("lost session with zookeeper");
                    } else if (state == ConnectionState.CONNECTED) {
                        //连接新建
                        logger.info("connected with zookeeper");
                    } else if (state == ConnectionState.RECONNECTED) {
                        logger.info("reconnected with zookeeper");
                    }
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

        return client;
    }
}
