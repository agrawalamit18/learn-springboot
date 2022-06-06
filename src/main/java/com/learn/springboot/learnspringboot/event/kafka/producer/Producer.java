package com.learn.springboot.learnspringboot.event.kafka.producer;

import com.learn.springboot.learnspringboot.entity.People;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Producer {

    @Value("kafka.clientUrl")
    private String clientUrl;

    @Value("kafka.topic")
    private String clientTopic;

    public void produceMessage(final People people) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        try{
            kafkaProducer.send(new ProducerRecord<String, String>("test-topic", String.valueOf(people.getId()),
                    people.getUserName()));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }
    }
}