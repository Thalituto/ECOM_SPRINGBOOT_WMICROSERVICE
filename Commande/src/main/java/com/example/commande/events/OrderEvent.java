package com.example.commande.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class OrderEvent {

    private static final Logger Log=LoggerFactory.getLogger(OrderEvent.class);
    @KafkaListener(topics = "estore-events",groupId = "orderclient")
    public void reciveorder(String data){
        System.out.println("message reçu "+data);
    }

}
