package com.baizhi.test;

import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.util.IntrospectionUtil;

import java.util.ArrayList;
import java.util.List;

public class TestHbase {
    private Configuration configuration;
    private Connection conn;
    private  Admin admin;
    @Before
    public void getClient()throws Exception{
        configuration = new Configuration();
        configuration.set("hbase.zookeeper.quorum", "HadoopNode00");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        conn = ConnectionFactory.createConnection(configuration);
        admin = conn.getAdmin();
    }
    @Test
    public void createNameSpace()throws Exception{
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create("baizhi123").addConfiguration("admin", "gjf").build();
        admin.createNamespace(namespaceDescriptor);
    }
    @Test
    public void listNameSpace()throws Exception{
        NamespaceDescriptor[] namespaceDescriptors = admin.listNamespaceDescriptors();
        for(NamespaceDescriptor listNamespaceDescriptor:namespaceDescriptors){
            System.out.println(listNamespaceDescriptor.getName());
        }
    }
    @Test
    public void modifyNameSpace()throws Exception{
        NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create("baizhi123").addConfiguration("aa", "bb").removeConfiguration("admin").build();
        admin.modifyNamespace(namespaceDescriptor);
    }
    @Test
    public void deleteNameSpace()throws Exception{
        admin.deleteNamespace("baizhi123");
    }
    @Test
    public void createTables()throws Exception{
        /**
         * 创建表名的对象（封装表名字）
         */
        TableName tableName = TableName.valueOf("baizhi:t_user1");
        /**
         * 封装表的相关信息
         */
        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
        /**
         * 封装列簇的相关信息
         */
        HColumnDescriptor cf1 = new HColumnDescriptor("cf1");
        cf1.setMaxVersions(3);

        HColumnDescriptor cf2 = new HColumnDescriptor("cf2");
        cf2.setMaxVersions(3);
        /**
         * 在hTableDescriptor对象中添加列簇描述对象
         */
        hTableDescriptor.addFamily(cf1);
        hTableDescriptor.addFamily(cf2);
        /**
         * 创建table
         */
        admin.createTable(hTableDescriptor);
    }
    @Test
    public void dropTable()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user1");
        admin.disableTable(tableName);
        admin.deleteTable(tableName);

    }
    @Test
    public void testPutOne()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        /**
         * 通过conn对象获得table的操作对象
         */
        Table table = conn.getTable(tableName);
        Put put1 = new Put("6".getBytes());
        put1.addColumn("cf1".getBytes(),"name".getBytes(),"zhangsan".getBytes());
        put1.addColumn("cf1".getBytes(),"age".getBytes(),"45".getBytes());
        put1.addColumn("cf1".getBytes(),"sex".getBytes(),"true".getBytes());
        table.put(put1);
        table.close();
    }
    @Test
    public void testPuList()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        BufferedMutator bufferedMutator = conn.getBufferedMutator(tableName);

        Put put1 = new Put("2".getBytes());
        put1.addColumn("cf1".getBytes(),"name".getBytes(),"zhangsan".getBytes());
        put1.addColumn("cf1".getBytes(),"name".getBytes(),"lisi".getBytes());
        put1.addColumn("cf1".getBytes(),"name".getBytes(),"wangwu".getBytes());

        Put put2 = new Put("3".getBytes());
        put2.addColumn("cf1".getBytes(),"name".getBytes(),"huxz".getBytes());
        put2.addColumn("cf1".getBytes(),"name".getBytes(),"huxz1".getBytes());
        put2.addColumn("cf1".getBytes(),"name".getBytes(),"huxz2".getBytes());

        Put put3 = new Put("6".getBytes());
        put3.addColumn("cf1".getBytes(),"name".getBytes(),"lisi1".getBytes());
        put3.addColumn("cf1".getBytes(),"name".getBytes(),"fufu".getBytes());
        put3.addColumn("cf1".getBytes(),"name".getBytes(),"dudu".getBytes());

        ArrayList<Put> puts = new ArrayList<>();
        puts.add(put1);
        puts.add(put2);
        puts.add(put3);

        bufferedMutator.mutate(puts);
        bufferedMutator.close();
    }
    @Test
    public void testDelete()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        Table table = conn.getTable(tableName);
        Delete delete = new Delete("6".getBytes());
        table.delete(delete);
        table.close();
    }
    @Test
    public void testDeleteList()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        BufferedMutator bufferedMutator = conn.getBufferedMutator(tableName);

        Delete delete = new Delete("4".getBytes());
        Delete delete1 = new Delete("5".getBytes());
        Delete delete2 = new Delete("6".getBytes());

        ArrayList<Delete> deletes = new ArrayList<>();
        deletes.add(delete);
        deletes.add(delete1);
        deletes.add(delete2);

        bufferedMutator.mutate(deletes);

        bufferedMutator.close();
    }
    @Test
    public void testGet()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        Table table = conn.getTable(tableName);
        Get get = new Get("4".getBytes());

        Result result = table.get(get);
        byte[] name = result.getValue("cf1".getBytes(),"name".getBytes());
        byte[] age = result.getValue("cf1".getBytes(), "age".getBytes());
        byte[] sex = result.getValue("cf1".getBytes(), "sex".getBytes());

        System.out.println(new String(name) +"_"+new java.lang.String(age)+"_"+new String(sex));

    }
    @Test
    public void testGet02()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        Table table = conn.getTable(tableName);

        Get get = new Get("7".getBytes());

        get.addColumn("cf1".getBytes(),"name".getBytes());
        Result result = table.get(get);
        List<Cell> columnCells = result.getColumnCells("cf1".getBytes(), "name".getBytes());
        for(Cell column:columnCells){
            byte[] rowkey = CellUtil.cloneRow(column);
            byte[] cf = CellUtil.cloneFamily(column);
            byte[] qualifier = CellUtil.cloneQualifier(column);
            byte[] value = CellUtil.cloneValue(column);
            long timestamp = column.getTimestamp();
            System.out.println(new String(rowkey)+"_"+new String(cf)+"_"+new String(qualifier)+"_"+new String(value)+"_"+timestamp);

        }
    }
    @Test
    public void testScan()throws Exception{
        TableName tableName = TableName.valueOf("baizhi:t_user");
        Table table = conn.getTable(tableName);
        Scan scan = new Scan();
        PrefixFilter prefixFilter1 = new PrefixFilter("4".getBytes());
        PrefixFilter prefixFilter2 = new PrefixFilter("5".getBytes());
        PrefixFilter prefixFilter3 = new PrefixFilter("6".getBytes());
        PrefixFilter prefixFilter4 = new PrefixFilter("7".getBytes());
        FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ONE, prefixFilter1, prefixFilter2, prefixFilter3,prefixFilter4);
        scan.setFilter(list);
        ResultScanner results = table.getScanner(scan);
        for(Result result:results){
            byte[] row = result.getRow();
            byte[] name = result.getValue("cf1".getBytes(), "name".getBytes());
            byte[] age = result.getValue("cf1".getBytes(), "age".getBytes());
            byte[] sex = result.getValue("cf1".getBytes(), "sex".getBytes());
            System.out.println(new String(row)+"__"+new String(name)+"__"+new String(age)+"__"+new String(sex));
        }

    }
    @After
    public void close()throws Exception{
        admin.close();
        conn.close();
    }
}
