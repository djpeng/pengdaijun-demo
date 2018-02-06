package com.pengdaijun.demo.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person_t")
public class PersonModel extends BaseModel {
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	// @OneToOne
	// private AddressModel address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// public AddressModel getAddress() {
	// return address;
	// }
	//
	// public void setAddress(AddressModel address) {
	// this.address = address;
	// }
}