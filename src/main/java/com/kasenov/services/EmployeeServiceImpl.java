package com.kasenov.services;

import com.kasenov.DAO.EmployeeDAOImpl;
import com.kasenov.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImpl  implements EmployeeService{
    private EmployeeDAOImpl employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional()
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee, int id) {
        employeeDAO.updateEmployee(employee, id);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }
}
