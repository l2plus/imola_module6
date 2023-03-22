package com.epam.sarai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class EmployeeConsumerApplication {

    public static void main(String[] args) throws RestClientException {
        SpringApplication.run(EmployeeConsumerApplication.class, args);
    }
}
