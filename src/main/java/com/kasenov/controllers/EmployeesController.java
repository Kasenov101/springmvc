package com.kasenov.controllers;

import com.kasenov.DAO.EmployeeDAOImpl;
import com.kasenov.entity.Employee;
import com.kasenov.services.EmployeeService;
import com.kasenov.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workspace")
public class EmployeesController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public String getWorkspace() {
        return "workspace/index";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model){
        model.addAttribute("employees", employeeService.getEmployees());
        return "/workspace/employees";
    }

    @GetMapping("/employee/{id}")
    public String showEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "/workspace/employee";
    }
}
