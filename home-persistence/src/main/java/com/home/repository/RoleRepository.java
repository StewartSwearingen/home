package com.home.repository;

import org.springframework.data.repository.CrudRepository;

import com.home.entity.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

}