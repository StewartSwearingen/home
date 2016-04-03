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
import com.home.entity.AddressEntity;
import com.home.entity.CustomerEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value = { "classpath:persistence-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup({"/dbunit/customer.xml", "/dbunit/address.xml"})
@ActiveProfiles("H2")
public class CustomerRepositoryIT {

	private static final String LAST_NAME = "Simpson";
	private static final String CITY = "Springfield";
	@Inject
	private CustomerRepository repository;

	@Test 
	public void testFindAll(){
		Assert.assertTrue(repository.findAll().iterator().hasNext());
	}
	
	@Test 
	public void testFindByLastName(){
		Assert.assertTrue(!repository.findByLastName(LAST_NAME).isEmpty());
	}
	
	@Test 
	public void testFindByAddressesCity(){
		Assert.assertTrue(!repository.findByAddressesCity(CITY).isEmpty());
	}
	
	@Test 
	@Transactional
	public void testAddressExists(){
		for (CustomerEntity customer : repository.findAll()){
			Assert.assertTrue(!customer.getAddresses().isEmpty());
		}
	}
	
	@Test
	@Transactional
	public void testAddAddress(){
		CustomerEntity customer = repository.findAll().iterator().next();
		Integer beforeSize = customer.getAddresses().size();
		AddressEntity address = new AddressEntity();
		address.setStreet("1515 Evergreen Terr");
		address.setCity("Springfield");
		customer.getAddresses().add(address);
		repository.save(customer);
		customer = repository.findOne(customer.getId());
		Assert.assertEquals(beforeSize + 1, customer.getAddresses().size());
	}
}