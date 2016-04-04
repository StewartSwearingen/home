package com.home.repository;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.home.support.BaseIntegrationTest;

public class RoleRepositoryIT extends BaseIntegrationTest {

	@Inject
	private RoleRepository roleRepository;

	@Test
	public void findAll() {
		Assert.assertTrue(roleRepository.findAll().iterator().hasNext());
	}

	@Test
	public void findCwnerExists() {
		Assert.assertNotNull(roleRepository.findAll().iterator().next().getOwner());
	}
}