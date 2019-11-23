package by.bsu.samples.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"by.bsu.samples.microservice.controller, by.bsu.samples.microservice.service, by.bsu.samples.microservice.executor, by.bsu.samples.microservice.parser"})
public class MicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

}
