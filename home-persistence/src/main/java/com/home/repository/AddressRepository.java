package com.home.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.home.entity.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

    List<AddressEntity> findByCity(String city);
}