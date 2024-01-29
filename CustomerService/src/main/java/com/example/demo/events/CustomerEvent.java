package com.example.demo.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEvent {

    private static final Logger Log= LoggerFactory.getLogger(CustomerEvent.class);
    @KafkaListener(topics = "estore-events",groupId = "customerclient")
    public void listen(String data){

        System.out.println("message reçu "+data);
    }

    @KafkaListener(topics = "order-events",groupId = "customerclient")
    public void listenM(){
        System.out.println("Message reçu");
    }

}
