package com.epam.sarai.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class FirstController {

    @GetMapping("/message")
    public String employeeMessage(@RequestHeader("first-request") String header) {
        System.out.println("First request RequestHeader: " + header);

        return "First service was called: " + this.getClass();
    }
}
