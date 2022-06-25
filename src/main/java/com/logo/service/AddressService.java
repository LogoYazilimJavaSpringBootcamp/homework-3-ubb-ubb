package com.logo.service;

import com.logo.model.company.Address;
import com.logo.model.invoice.Invoice;
import com.logo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    AddressRepository addressRepository;


    public Address save(Address address) {
        return addressRepository.save(address);
    }
    public Address findById( long id ) {
        return addressRepository.findById(id);
    }

    public Address deleteById(long id) {
        return addressRepository.deleteById(id);
    }

    public Address update(Address address) {

        Address addressToUpdate = addressRepository.findById(address.getId()).get();

        addressToUpdate.setProvince(address.getProvince());

        return addressRepository.save(addressToUpdate);
    }


}
