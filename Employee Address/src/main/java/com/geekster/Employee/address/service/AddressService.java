package com.geekster.Employee.address.service;

import com.geekster.Employee.address.models.Address;
import com.geekster.Employee.address.repositories.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;

    public String insertAddress(List<Address> address) {
         Iterable<Address> added = iAddressRepo.saveAll(address);
         if(added != null){
             return "Added Successfully...";
         }
         return "failed...!!!";
    }

    public void updateById(Long id, String zipcode) {
        Optional<Address> find = iAddressRepo.findById(id);
        Address details = find.get();
        details.setZipcode(zipcode);
        iAddressRepo.save(details);

    }

    public void deleteById(Long id) {
        iAddressRepo.deleteById(id);
    }

    public List<Address> getAllAddress() {
       return iAddressRepo.findAll();
    }

    public Optional<Address> getById(Long id) {
       return iAddressRepo.findById(id);
    }
}
