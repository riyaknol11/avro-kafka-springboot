package com.knoldus.producer;

import com.knoldus.model.CoffeeOrder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class CoffeeOrderProducer {
    public static final Logger log = LoggerFactory.getLogger(CoffeeOrderProducer.class);

    private static final String COFFEE_ORDERS_TOPIC = "coffee-orders";

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());


        KafkaProducer<String, byte[]> producer = new KafkaProducer<String, byte[]>(properties);

        CoffeeOrder coffeeOrder = CoffeeOrderUtil.buildOrder();

        byte[] value = coffeeOrder.toByteBuffer().array();

        ProducerRecord<String, byte[]> producerRecord =
                new ProducerRecord<>(COFFEE_ORDERS_TOPIC, value);

        var recordMetaData = producer.send(producerRecord).get();
        log.info("recordMetaData : " + recordMetaData);

    }

}
