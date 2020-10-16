package edu.miu.e_mart.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotEmpty(message = "{validate.notEmpty}")
	private String firstName;
	 @NotEmpty(message = "{validate.notEmpty}")
	private String lastName;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private ARole role;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private ACredential acredential;
	 @Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product>products = new ArrayList<>();

	public Admin() {
		super();
	}

	public Admin(int adminId, String firstName, String lastName, ARole role, ACredential acredential, Address address,
			List<Product> products) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.acredential = acredential;
		this.address = address;
		this.products = products;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public ARole getRole() {
		return role;
	}

	public void setRole(ARole role) {
		this.role = role;
	}

	public ACredential getAcredential() {
		return acredential;
	}

	public void setAcredential(ACredential acredential) {
		this.acredential = acredential;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
}
