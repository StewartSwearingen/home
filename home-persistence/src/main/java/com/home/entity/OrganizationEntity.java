package com.home.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZATION")
public class OrganizationEntity {

	@Id
	@Column(name = "ORG_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
	@JoinTable(name = "PARTY_ORG_ROLE", joinColumns = {
			@JoinColumn(name = "ORG_ID", referencedColumnName = "ORG_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "PARTY_ID", referencedColumnName = "PARTY_ID", unique = true) })
	@MapKeyJoinColumn(name = "ROLE_ID")
	private Map<RoleEntity, PartyEntity> parties;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<RoleEntity, PartyEntity> getParties() {
		return parties;
	}

}
