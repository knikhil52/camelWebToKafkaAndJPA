package com.kafkatest.producer.controller;

import com.kafkatest.producer.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
@Slf4j
public class ProducerController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping
    public ResponseEntity<String> postStudent(@RequestBody Student student){
    log.info(student.toString()+" Student received");
    producerTemplate.sendBody("direct:studentProducer",student);
    return new ResponseEntity<>("Sent to Kafka", HttpStatus.CREATED);
    }
}
