package com.baizhi;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.List;

public class App {
    private MongoClient mongoClient;

    /*
     * 运行juint 测试的时候，before会作为前置运行的用例
     * */
    @Before
    public void getClient() {

        mongoClient = new MongoClient("192.168.11.128", 27017);


    }

    @Test
    public void test02() {

        MongoDatabase baizhi = mongoClient.getDatabase("baizhi");
        for (String listCollectionName : baizhi.listCollectionNames()) {


            System.out.println(listCollectionName);
        }

    }

    @Test
    public void testSelectAll() {

        /*
        先拿到数据库对象
        * */
        MongoDatabase baizhi = mongoClient.getDatabase("baizhi");

        /*
         * 通过数据对象拿到集合对象
         * 通过find（）查找所有数据
         * */
        FindIterable<Document> user = baizhi.getCollection("user").find();


        /*
         * 遍历集合
         * */
        for (Document document : user) {


            String s = document.toJson();

            System.out.println(s);
        }


    }

    @Test
    public void testSelectOne() {

        FindIterable<Document> documents = mongoClient.getDatabase("baizhi").getCollection("user").find(new Document());


        documents.forEach((Block<? super Document>) (asdadas) -> {
           // System.out.println(asdadas.toJson());
        });


      /*  List<String> strings = Arrays.asList("123", "123", "123");

        strings.forEach((qwe)->{ System.out.println(qwe); });*/


        FindIterable<Document> documents1 = mongoClient.getDatabase("baizhi").getCollection("user").find(new Document("name", "gjf"));

        documents1.forEach((Block<? super Document>) (a)->{

            System.out.println(a.toJson());
        });
    }

    @Test
    public void insertOne(){

        MongoCollection<Document> collection = mongoClient.getDatabase("baizhi").getCollection("user");

        Document append = new Document("name", "gjf").append("lianxiren", new Document("w", 123).append("h", 123).append("phone", "123")).append("stars", 3)
                .append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));


        /*
        * {name:"cafe",contact:{phone:123,email:123,location:123},stars:3,categories:[1,2,3]}
        *
        * */


        collection.insertOne(append);

      collection.find()

    }

    @After
    public void close() {


        mongoClient.close();
    }
}
