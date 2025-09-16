package com.kafkatest.consumer.route;

import com.kafkatest.consumer.model.Student;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaStudentReceiverRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:{{kafka.topic}}")
                .routeId("student-consumer")
                .unmarshal().json(Student.class)
                .log("${body}");
    }
}
