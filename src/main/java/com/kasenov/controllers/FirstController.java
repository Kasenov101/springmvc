package com.kasenov.controllers;

import com.kasenov.entity.Employee;
import com.kasenov.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;

@Controller
public class FirstController {
    EmployeeService employeeService;
    @Autowired
    public FirstController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping( "/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/info")
    public String getInfoPage(){
        return "info";
    }
}

