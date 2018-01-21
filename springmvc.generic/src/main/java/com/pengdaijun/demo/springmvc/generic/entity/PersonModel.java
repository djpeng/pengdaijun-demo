package com.pengdaijun.demo.springmvc.generic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_t")
// @XmlRootElement(name = "person")
// @XmlAccessorType(XmlAccessType.FIELD)
public class PersonModel implements IBaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// public AddressModel getAddress() {
	// return address;
	// }
	//
	// public void setAddress(AddressModel address) {
	// this.address = address;
	// }
}