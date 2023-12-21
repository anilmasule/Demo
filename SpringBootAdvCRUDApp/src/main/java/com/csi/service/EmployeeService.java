package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void signUp(Employee employee);

    public boolean signIn(Employee employee);

    public void saveAllData(List<Employee> employees);

    public List<Employee>getAllData();

    public Employee getDataById(int empId);

    public Employee getDataByName(String empName);

    public void updateData(int empId, Employee employee);

    public void deleteData(int empId);

    public void deleteAllData();
}
