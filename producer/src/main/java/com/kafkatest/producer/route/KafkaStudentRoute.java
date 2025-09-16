package com.kafkatest.producer.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaStudentRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:studentProducer")
                .routeId("student-producer")
                .log("Student in route ${body}")
                .marshal().json()
                .to("kafka:{{kafka.topic}}");
    }
}
