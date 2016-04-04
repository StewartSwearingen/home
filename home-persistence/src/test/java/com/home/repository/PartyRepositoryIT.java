package com.home.repository;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.home.entity.PartyEntity;
import com.home.entity.RoleEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:persistence-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup({ "/dbunit/party.xml", "/dbunit/role.xml" })
@ActiveProfiles("H2")
public class PartyRepositoryIT {

	private static final String LAST_NAME = "Simpson";
	private static final String ROLE = "Donut Eater";
	@Inject
	private PartyRepository repository;

	@Test
	public void testFindAll() {
		Assert.assertTrue(repository.findAll().iterator().hasNext());
	}

	@Test
	public void testFindByLastName() {
		Assert.assertTrue(!repository.findByLastName(LAST_NAME).isEmpty());
	}

	@Test
	public void testFindByAddressesCity() {
		Assert.assertTrue(!repository.findByRolesName(ROLE).isEmpty());
	}

	@Test
	@Transactional
	public void testAddressExists() {
		for (PartyEntity customer : repository.findAll()) {
			Assert.assertTrue(!customer.getRoles().isEmpty());
		}
	}

	@Test
	@Transactional
	public void testAddRole() {
		PartyEntity customer = repository.findAll().iterator().next();
		Integer beforeSize = customer.getRoles().size();
		RoleEntity address = new RoleEntity();
		address.setName("Safety Inspector");
		customer.getRoles().add(address);
		repository.save(customer);
		customer = repository.findOne(customer.getId());
		Assert.assertEquals(beforeSize + 1, customer.getRoles().size());
	}
}