package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public String signUp(@RequestBody Employee employee)
    {
        employeeService.signUp(employee);

        return "Employee Signup Successfully";
    }

    @PostMapping("/signin")
    public boolean signIn(@RequestBody Employee employee)
    {
        return employeeService.signIn(employee);
    }

    @GetMapping("/getalldata")
    public List<Employee> getAllData()
    {
        return employeeService.getAllData();
    }

    @GetMapping("/getdatabyid/{empId}")
    public Employee getDataById(@PathVariable int empId)
    {
        return employeeService.getDataById(empId);
    }

    @GetMapping("/getdatabyname/{empName}")
    public Employee getDataByName(@PathVariable String empName)
    {
        return employeeService.getDataByName(empName);
    }

    @PostMapping("/savealldata")
    public String saveAllData(@RequestBody List<Employee> employees)
    {
        employeeService.saveAllData(employees);
        return "Sall All Data Done";
    }

    @PutMapping("/updatedata/{empId}")
    public String updateData(@PathVariable int empId, @RequestBody Employee employee)
    {
        employeeService.updateData(empId, employee);
        return "Data updated Successfully";
    }

    @DeleteMapping("/deletedata/{empId}")
    public String deleteData(@PathVariable int empId)
    {
        employeeService.deleteData(empId);
        return "Data deleted Successfully";
    }

    @DeleteMapping("/deletealldata")
    public String deleteAllData()
    {
        employeeService.deleteAllData();
        return "All Data Deleted Successfully";
    }
}
