package com.epam.sarai.Controller;

import com.epam.sarai.Domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeProducerController {

    @GetMapping(value = "/employee")
    public Employee getFirstEmployee() {

        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setDesignation("Accountant");
        employee.setEmpId("1");
        employee.setSalary(35000);

        return employee;
    }
}
