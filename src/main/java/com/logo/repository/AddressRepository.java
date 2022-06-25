package com.logo.repository;

import com.logo.model.company.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface AddressRepository extends CrudRepository<Address,Long> {

    public Address findByProvince(String province);
    public Address findByCountry(String country);
    public Address findById(long id);
    public Address deleteById(long id);

}
