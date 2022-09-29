package com.kasenov.controllers;

import com.kasenov.DAO.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workspace")
public class EmployeesController {

    private final EmployeeDAOImpl employeeDAOImpl;

    @Autowired
    public EmployeesController(EmployeeDAOImpl employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @GetMapping("/index")
    public String getWorkspace() {
        return "workspace/index";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model){
       // model.addAttribute("employees", employeeDAOImpl.getAllEmployees());
        return "/workspace/employees";
    }

    @GetMapping("/employee/{id}")
    public String showEmployee(@PathVariable("id") int id, Model model){
       // model.addAttribute("employee", employeeDAOImpl.getEmpForId(id));
        return "/workspace/employee";
    }
}
