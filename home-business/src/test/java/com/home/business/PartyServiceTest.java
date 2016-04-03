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

import com.home.entity.PartyEntity;
import com.home.repository.PartyRepository;

public class PartyServiceTest {

	@InjectMocks
	private PartyServiceImpl partyService;

	@Mock
	private PartyRepository partyRepository;

	private List<PartyEntity> parties = new ArrayList<PartyEntity>();

	@Mock
	private PartyEntity partyEntity;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		parties.add(partyEntity);
		Mockito.when(partyRepository.findAll()).thenReturn(parties);
		Assert.assertTrue(!partyService.getCustomers().isEmpty());
	}
}
