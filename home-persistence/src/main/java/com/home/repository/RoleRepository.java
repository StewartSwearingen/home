package com.home.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.home.entity.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

	List<RoleEntity> findByName(String name);
}