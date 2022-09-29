package com.kasenov.DAO;

import com.kasenov.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
    }

    @Override
    public Employee getEmployee(int id) {
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> arrayList = new ArrayList<>();
        arrayList = session.createQuery("from Employee", Employee.class).getResultList();
        return arrayList;
    }
}
