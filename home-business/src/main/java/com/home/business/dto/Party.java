package com.home.business.dto;

public class Party {

	private String name;

	public Party() {

	}

	public Party(String firstName, String lastName) {
		this.name = new StringBuilder(firstName).append(" ").append(lastName).toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
