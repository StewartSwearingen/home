package com.home.repository;

import org.springframework.data.repository.CrudRepository;

import com.home.entity.PartyEntity;

public interface PartyRepository extends CrudRepository<PartyEntity, Long> {

}