package com.home.repository;

import org.springframework.data.repository.CrudRepository;

import com.home.entity.OrganizationEntity;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {

}