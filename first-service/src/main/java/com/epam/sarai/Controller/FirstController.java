package com.epam.sarai.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class FirstController {

    @GetMapping("/message")
    public String employeeMessage() {
        return "First service was called: " + this.getClass();
    }
}