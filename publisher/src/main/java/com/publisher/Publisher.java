package com.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Publisher {

    static final String topicExchangeName = "spring-boot-exchange";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello from RabbitMQ!";
        System.out.println("Sent message <" + message + ">");
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.baz", message);

    }

    public static void main(String[] args) {
        SpringApplication.run(Publisher.class, args);
    }

}
