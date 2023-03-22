package com.epam.sarai.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class SecondController {

    @GetMapping("/message")
    public String consumerMessage(@RequestHeader("second-request") String header) {
        System.out.println("Second request RequestHeader: " + header);

        return "Second service was called: " + this.getClass();
    }
}