package com.example.demo.kafkaclient;

import java.time.Duration;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaClientSample {

	public static void main(String[] args) {
		Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test-1");
        props.put("enable.auto.commit", "false"); //取消自动提交
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1000));
        
        
        consumer.commitSync();
        
	}
	
}
