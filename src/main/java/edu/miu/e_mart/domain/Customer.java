
package edu.miu.e_mart.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	 @NotEmpty(message = "{validate.notEmpty}")
	private String firstName;
	 @NotEmpty(message = "{validate.notEmpty}")
	private String lastName;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private ACredential acredential;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private ARole role;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Customer() {

	}

	public Customer(String firstName, String lastName, Payment payment, ACredential acredential, ARole role,
			Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.payment = payment;
		this.acredential =acredential;
		this.role = role;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public ARole getRole() {
		return role;
	}

	public void setRole(ARole role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ACredential getAcredential() {
		return acredential;
	}

	public void setAcredential(ACredential acredential) {
		this.acredential = acredential;
	}

}
