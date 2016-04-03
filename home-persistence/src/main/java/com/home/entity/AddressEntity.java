package com.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {

    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @Column(name="STREET")
    private String street;
    
    @Column(name="CITY")
    private String city;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private PartyEntity owner;
    
    public AddressEntity() {
    	
    }

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PartyEntity getOwner() {
		return owner;
	}

	public void setOwner(PartyEntity owner) {
		this.owner = owner;
	}

    

}