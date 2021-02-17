package com.mytest.ptworker.base.zk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytest.ptworker.base.biz.ModifyQps;
import com.mytest.ptworker.base.biz.QueryStatus;
import com.mytest.ptworker.base.biz.TcStart;
import com.mytest.ptworker.base.biz.TcStop;
import com.mytest.ptworker.base.wrapper.ZkClient;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class QpsListener implements NodeCacheListener {

    @Autowired
    private ZkClient zkClient;

    private NodeCache nodeCache;

    @PostConstruct
    public void init(){
        this.nodeCache = zkClient.watchPath("/pt/qps", this);
    }

    @Override
    public void nodeChanged() throws Exception {
        byte[] currentData = this.nodeCache.getCurrentData().getData();
        JSONObject jsonObject =JSON.parseObject(new String(currentData));
        String methodType=jsonObject.getString("methodType");
        String tcId=jsonObject.getString("tcId");
        Integer threadCount=jsonObject.getInteger("threadCount");
        Integer cyclesCount=jsonObject.getInteger("cyclesCount");
        switch (methodType){
            case "startLoadTest":
                TcStart tcStart=new TcStart();
                tcStart.tcStart(tcId,threadCount,cyclesCount);
                break;
            case "modifyQps":
                ModifyQps modifyQps=new ModifyQps();
                modifyQps.modifyQps(tcId,threadCount,cyclesCount);
                break;
            case "stopLoadTest":
                TcStop tcStop=new TcStop();
                tcStop.tcStop();
                break;
            case "queryStatus":
                QueryStatus queryStatus=new QueryStatus();
                queryStatus.queryStatus();
                break;
            default:
                break;
        }

    }
}
