package com.home.business;

import java.util.Collection;

import javax.inject.Inject;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.home.business.dto.Party;
import com.home.entity.PartyEntity;
import com.home.repository.PartyRepository;

public class PartyServiceImpl implements PartyService {

	@Inject
	private PartyRepository customerRepository;

	public Collection<Party> getCustomers() {
		// Transfroms Entities List<CustomerEntity> to List<Customer> DTO
		return (Collection<Party>) Collections2.transform((Collection<PartyEntity>) customerRepository.findAll(),
				new Function<PartyEntity, Party>() {

					public Party apply(PartyEntity customerEntity) {
						return new Party(customerEntity.getFirstName(), customerEntity.getLastName());
					}

				});
	}

}
