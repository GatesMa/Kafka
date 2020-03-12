package com.gatesma.kafkalearn.chapter1;

import org.apache.kafka.clients.producer.ProducerConfig;

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

    public static void main(String[] args) {
        Properties properties = new Properties();
        //设置key序列化器
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        //设置值序列化器
        properties.put()


    }

}
