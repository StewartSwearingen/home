package com.home.repository;

import javax.inject.Inject;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:persistence-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup({ "/dbunit/party.xml", "/dbunit/address.xml" })
@ActiveProfiles("H2")
public class AddressRepositoryIT {

	@Inject
	private AddressRepository addressRepository;

	@Test
	public void findAll() {
		Assert.assertTrue(addressRepository.findAll().iterator().hasNext());
	}

	@Test
	public void findCustomerExists() {
		Assert.assertNotNull(addressRepository.findAll().iterator().next().getOwner());
	}
}