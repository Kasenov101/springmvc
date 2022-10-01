package com.kasenov.controllers;

import com.kasenov.DAO.EmployeeDAOImpl;
import com.kasenov.entity.Employee;
import com.kasenov.services.EmployeeService;
import com.kasenov.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

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

    @GetMapping("/employee/new")
    public String addNewEmployeeForm() {
        return "/workspace/employee/new";
    }

    @PostMapping("/employee/new")
    public String addNewEmployee(Model model, @RequestParam("iin") String iin,
                                 @RequestParam("first_name") String firstName,
                                 @RequestParam("last_name") String lastName, @RequestParam("surname") String surname,
                                 @RequestParam("birthday") Date birthday,
                                 @RequestParam("phone_num") String phoneNum, @RequestParam("department")
                                 String department, @RequestParam("salary") int salary,
                                 @RequestParam("recruitment_date") Date recruitmentDate
    ) {
        Employee employee = new Employee();
        employee.setIin(iin);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSurname(surname);
        employee.setBirthday(birthday.toLocalDate());
        employee.setSalary(salary);
        employee.setPhoneNumber(phoneNum);
        employee.setDepartment(department);
        employee.setRecruitmentDate(recruitmentDate.toLocalDate());
        employeeService.addEmployee(employee);
        return "redirect:/workspace/employees";
    }
}
