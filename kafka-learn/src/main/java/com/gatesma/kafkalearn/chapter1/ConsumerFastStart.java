package com.gatesma.kafkalearn.chapter1;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * Copyright (C), 2020
 * FileName: ConsumerFastStart
 * Author:   Marlon
 * Email: gatesma@foxmail.com
 * Date:     2020/3/12 20:47
 * Description:
 */
public class ConsumerFastStart {

    private static final String Broker_List = "localhost:9092";

    private static final String Topic = "heima";

    private static final String Group_Id = "group. ";

    public static void main(String[] args) {
        Properties properties = new Properties();
        //properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //properties.put("bootstrap.servers", Broker_List);
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Broker_List);
        //properties.put("group.id", Group_Id);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, Group_Id);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList(Topic));
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }

    }

}
