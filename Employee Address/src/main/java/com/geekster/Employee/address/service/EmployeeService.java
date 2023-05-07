package com.geekster.Employee.address.service;

import com.geekster.Employee.address.models.Address;
import com.geekster.Employee.address.models.Employee;
import com.geekster.Employee.address.repositories.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public String saveEmployee(List<Employee> employees) {
        Iterable<Employee> added = iEmployeeRepo.saveAll(employees);
        if(added != null){
            return "Added Successfully...";
        }
        return "Failed..!!";
    }

    public List<Employee>  getAllEmployee() {
        return iEmployeeRepo.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return iEmployeeRepo.findById(id);
    }

    public void updateById(Long id,String state) {
        Optional<Employee> find = iEmployeeRepo.findById(id);
        Employee employeeDetails = find.get();
        Address AllAddress =employeeDetails.getAddress();
        AllAddress.setState(state);
        iEmployeeRepo.save(employeeDetails);
    }

    public void deleteById(Long id) {
        iEmployeeRepo.deleteById(id);
    }
}
