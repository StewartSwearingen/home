package com.home.business;

import java.util.Collection;

import javax.inject.Inject;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.home.business.dto.Customer;
import com.home.entity.CustomerEntity;
import com.home.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerRepository customerRepository;

	public Collection<Customer> getCustomers() {
		// Transfroms Entities List<CustomerEntity> to List<Customer> DTO
		return (Collection<Customer>) Collections2.transform((Collection<CustomerEntity>) customerRepository.findAll(),
				new Function<CustomerEntity, Customer>() {

					public Customer apply(CustomerEntity customerEntity) {
						return new Customer(customerEntity.getFirstName(), customerEntity.getLastName());
					}

				});
	}

}
