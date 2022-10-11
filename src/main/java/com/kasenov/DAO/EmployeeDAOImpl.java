package com.kasenov.DAO;

import com.kasenov.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public void updateEmployee(Employee employee, int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set iin= :iin, firstName = :firstName, " +
                "lastName = :lastName, surname = : surname, birthday = :birthday, phoneNumber = :phoneNumber, " +
                "department = :department, salary = :salary, recruitmentDate = :recruitmentDate where id = :id");

        query.setParameter("iin", employee.getIin());
        query.setParameter("firstName", employee.getFirstName());
        query.setParameter("lastName", employee.getLastName());
        query.setParameter("surname", employee.getSurname());
        query.setParameter("birthday", employee.getBirthday());
        query.setParameter("phoneNumber", employee.getPhoneNumber());
        query.setParameter("department", employee.getDepartment());
        query.setParameter("salary", employee.getSalary());
        query.setParameter("recruitmentDate", employee.getRecruitmentDate());
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee where id =" + id, Employee.class).getSingleResult();
    }

    @Override
    public void deleteEmployee(int id) {
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> arrayList = new ArrayList<>();
        arrayList = session.createQuery("from Employee", Employee.class).list();
        return arrayList;
    }
}
