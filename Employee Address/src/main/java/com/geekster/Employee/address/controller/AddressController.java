package com.geekster.Employee.address.controller;

import com.geekster.Employee.address.models.Address;
import com.geekster.Employee.address.models.Employee;
import com.geekster.Employee.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/")
    public  List<Address>  getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping(value = "/byId{id}")
    public Optional<Address> getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping(value = "/data")
    public String saveAddress(@RequestBody List<Address> address) {
        return addressService.insertAddress(address);
    }

    @PutMapping(value = "/byId/{id}/Zipcode/{zipcode}")
    public void updateById(@PathVariable Long id, @PathVariable String zipcode) {
        addressService.updateById(id, zipcode);
    }

    @DeleteMapping(value = "/byId/{id}")
    public void deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
    }
}


//    GET /addresses/{id} - get an address byid


