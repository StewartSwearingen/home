package com.home.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.home.entity.PartyEntity;

public interface PartyRepository extends CrudRepository<PartyEntity, Long> {

    List<PartyEntity> findByLastName(String lastName);
    
    List<PartyEntity> findByAddressesCity(@Param("city") String city);
}