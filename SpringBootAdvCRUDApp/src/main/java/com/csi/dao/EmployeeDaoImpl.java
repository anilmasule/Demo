package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();
    }

    @Override
    public boolean signIn(Employee emp) {

       boolean flag = false;
        Session session = factory.openSession();

        List<Employee>empList=session.createQuery("from Employee").list();

        for(Employee employee: empList)
        {
            if(employee.getEmpEmailId().equals(employee.getEmpEmailId()) && employee.getEmpPassword().equals(employee.getEmpPassword()))
            {
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public void saveAllData(List<Employee> employees) {
        Session session = factory.openSession();
        for(Employee e:employees)
        {
            Transaction transaction = session.beginTransaction();
            session.save(e);
            transaction.commit();
        }
    }

    @Override
    public List<Employee> getAllData() {
        Session session = factory.openSession();
         List<Employee>empList = session.createQuery("from Employee").list();
        return empList;
    }

    @Override
    public Employee getDataById(int empId) {
        Session session = factory.openSession();
        Employee employee = (Employee) session.get(Employee.class, empId);
        return employee;
    }

    @Override
    public Employee getDataByName(String empName) {
        Session session = factory.openSession();
        List<Employee>employees = session.createQuery("from Employee").list();

        Employee ee = new Employee();
        for(Employee employee: employees) {
            if (employee.getEmpName().equals(empName)) {
                ee.setEmpId(employee.getEmpId());
                ee.setEmpName(employee.getEmpName());
                ee.setEmpAddress(employee.getEmpAddress());
                ee.setEmpContactNumber(employee.getEmpContactNumber());
                ee.setEmpDOB(employee.getEmpDOB());
                ee.setEmpEmailId(employee.getEmpEmailId());
                ee.setEmpPassword(employee.getEmpPassword());
            }
        }
        return ee;

    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Employee e1 = (Employee) session.get(Employee.class, empId);

        if(e1.getEmpId()==empId)
        {
            e1.setEmpName(employee.getEmpName());
            e1.setEmpAddress(employee.getEmpAddress());
            e1.setEmpContactNumber(employee.getEmpContactNumber());
            e1.setEmpDOB(employee.getEmpDOB());
            e1.setEmpEmailId(employee.getEmpEmailId());
            e1.setEmpPassword(employee.getEmpPassword());

            session.update(e1);
            transaction.commit();

        }


    }

    @Override
    public void deleteData(int empId) {

        Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
        Employee e1 = (Employee) session.get(Employee.class, empId);

        if(e1.getEmpId()==empId)
        {


            session.delete(e1);
            transaction.commit();

        }


    }

    @Override
    public void deleteAllData() {
        Session session = factory.openSession();
        List<Employee>empList = session.createQuery("from Employee").list();

        for(Employee employee: empList)
        {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
