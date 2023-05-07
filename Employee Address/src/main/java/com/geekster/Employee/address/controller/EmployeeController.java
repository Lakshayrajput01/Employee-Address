package com.geekster.Employee.address.controller;

import com.geekster.Employee.address.models.Employee;
import com.geekster.Employee.address.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/")
    public String saveEmployee(@RequestBody List<Employee> employees){
        return employeeService.saveEmployee(employees);
    }

    @GetMapping(value = "/")
    public  List<Employee>  getAllEmployee(){
       return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/byId{id}")
    public Optional<Employee> getById(@PathVariable Long id){
        return employeeService.getById(id);
    }


    @PutMapping(value = "/byId/{id}/State/{state}")
    public void updateById(@PathVariable Long id,@PathVariable String state){
        employeeService.updateById(id,state);
    }

    @DeleteMapping(value = "/byId/{id}")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
    }
}



