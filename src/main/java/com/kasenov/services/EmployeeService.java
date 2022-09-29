package com.kasenov.services;

import com.kasenov.entity.Employee;
import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    public List<Employee> getEmployees();
}
