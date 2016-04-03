package com.home.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.home.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastName(String lastName);
    
    List<CustomerEntity> findByAddressesCity(@Param("city") String city);
}