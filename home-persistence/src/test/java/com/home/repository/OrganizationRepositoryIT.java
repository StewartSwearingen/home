package com.home.repository;

import java.util.Map.Entry;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.home.entity.OrganizationEntity;
import com.home.entity.PartyEntity;
import com.home.entity.RoleEntity;
import com.home.support.BaseIntegrationTest;

public class OrganizationRepositoryIT extends BaseIntegrationTest {

	@Inject
	private OrganizationRepository organizationRepository;

	@Inject
	private RoleRepository roleRepository;

	@Inject
	private PartyRepository partyRepository;

	@Test
	public void testFindOne() {
		OrganizationEntity organizationEntity = organizationRepository.findOne(1l);
		Assert.assertNotNull(organizationEntity);
		Assert.assertTrue(!organizationEntity.getParties().isEmpty());
		for (Entry<RoleEntity, PartyEntity> entry : organizationEntity.getParties().entrySet()) {
			RoleEntity key = entry.getKey();
			PartyEntity value = entry.getValue();
			System.out.println(key.getName() + ": " + value.getFirstName() + " " + value.getLastName());
		}
	}

	@Test
	public void testAdd() {
		OrganizationEntity organizationEntity = organizationRepository.findOne(1l);
		Assert.assertNotNull(organizationEntity);
		Assert.assertTrue(!organizationEntity.getParties().isEmpty());
		Assert.assertEquals(1, organizationEntity.getParties().size());
		organizationEntity.getParties().put(roleRepository.findOne(2l), partyRepository.findOne(1l));
		organizationRepository.save(organizationEntity);
		Assert.assertEquals(2, organizationEntity.getParties().size());

	}

}