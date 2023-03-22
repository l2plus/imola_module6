package com.epam.sarai.Controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeConsumerController {

    private final String employeeProducerServiceName = "${employee.producer.service.name}";
    private final String employeeProducerServiceBaseUrl = "${employee.producer.service.baseurl}";
    private final DiscoveryClient discoveryClient;

    @GetMapping(value = "/employee-info")
    public ResponseEntity<String> getEmployee(@RequestHeader("employee-info-request") String header) throws RestClientException {
        System.out.println("Employee info request RequestHeader: " + header);

        List<ServiceInstance> instances = discoveryClient.getInstances(employeeProducerServiceName);
        ServiceInstance serviceInstance = instances.get(0);
        String baseUrl = serviceInstance.getUri().toString() + employeeProducerServiceBaseUrl;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = null;

        try {
            responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(responseEntity.getBody());

        return responseEntity;
    }

    private static HttpEntity<?> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        return new HttpEntity<>(headers);
    }

}
