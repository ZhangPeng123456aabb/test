package com.baizhi.zookeeper;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private CuratorFramework client;
    @Before
    public void getClient(){
        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 1000);
        client= CuratorFrameworkFactory.newClient("192.168.182.21:2181,192.168.182.22:2181,192.168.182.23:2181",retry);
        client.start();
    }
    @Test
    public void createNode()throws Exception{
        String s = client.create().withMode(CreateMode.PERSISTENT).forPath("/baizhi/4", "1123".getBytes());
        System.out.println(s);
    }
    @Test
    public void getNode()throws Exception{
        byte[] bytes = client.getData().forPath("/baizhi");
        System.out.println(new String(bytes));
    }
    @Test
    public void setNode()throws Exception{
        client.setData().forPath("/baizhi","123456zhangzhang4578945".getBytes());
    }
    @Test
    public void getChild()throws Exception{
        client.getChildren().forPath("/baizhi1").forEach((name)->{
            System.out.println(name);
        });
    }
    @Test
    public void testNodeChange()throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(2);
        NodeCache nodeCache = new NodeCache(client, "/baizhi", false);
        nodeCache.start();
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println(new java.lang.String(nodeCache.getCurrentData().getData()));
            }
        },pool);
        Thread.sleep(Long.MAX_VALUE);
    }
    @Test
    public void testChildChange()throws Exception{
        PathChildrenCache childrenCache = new PathChildrenCache(client, "/baizhi", true);
        childrenCache.start();
        childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()){
                    case CHILD_ADDED:
                        System.out.println("节点增加"+event.getData().getPath()+"它的值是"+new String(event.getData().getData()));
                        break;
                    case CHILD_REMOVED:
                        System.out.println("节点被删除"+event.getData().getPath());
                        break;
                    case CHILD_UPDATED:
                        System.out.println("节点被更新"+event.getData().getPath()+"它的值是"+new String(event.getData().getData()));
                        break;
                }
            }
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
    @Test
    public void delNode()throws Exception{
        client.delete().deletingChildrenIfNeeded().forPath("/baizhi/4");
    }
    @After
    public void close(){
        client.close();
    }
}
