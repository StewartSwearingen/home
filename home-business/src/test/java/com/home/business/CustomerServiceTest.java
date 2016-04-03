package com.home.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.home.entity.CustomerEntity;
import com.home.repository.CustomerRepository;

public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	private List<CustomerEntity> customers = new ArrayList<CustomerEntity>();

	@Mock
	private CustomerEntity customerEntity;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		customers.add(customerEntity);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		Assert.assertTrue(!customerService.getCustomers().isEmpty());
	}
}
