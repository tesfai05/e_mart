package edu.miu.e_mart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@NotEmpty(message = "{validate.notEmpty}")
	private String street;

	@NotEmpty(message = "{validate.notEmpty}")
	private String city;

	@NotEmpty(message = "{validate.notEmpty}")
	@Size(min = 2, max = 2, message = "{validate.state.size}")
	private String state;

	@Range(min=10000,max=99999,message = "{validate.size.zipcode}")
	@NotNull(message = "{validate.notNull}")
	private Integer zipCode;

	public Address() {
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipcode) {
		this.zipCode = zipcode;
	}

}
