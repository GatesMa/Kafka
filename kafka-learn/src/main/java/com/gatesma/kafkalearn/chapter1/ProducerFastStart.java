package com.gatesma.kafkalearn.chapter1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Copyright (C), 2020
 * FileName: ProducerFastStart
 * Author:   Marlon
 * Email: gatesma@foxmail.com
 * Date:     2020/3/12 20:07
 * Description:
 */
public class ProducerFastStart {

    private static final String Broker_List = "localhost:9092";

    private static final String Topic = "heima";

    public static void main(String[] args) {
        Properties properties = new Properties();
        //设置key序列化器
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        //设置值序列化器
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置集群地址
        properties.put("bootstrap.servers", Broker_List);

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>(Topic, "kafka-demo",
                "hello, kafka, Wakanda Forever!");

        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }

    }

}
