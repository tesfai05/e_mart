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
public class ACredential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int credentialId;

	@NotEmpty(message = "{validate.notEmpty}")
	private String userName;

	@NotEmpty(message = "{validate.notEmpty}")
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private ARole aroles;

	public ACredential() {

	}

	public ACredential(String userName, String password) {

		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ARole getAroles() {
		return aroles;
	}

	public void setAroles(ARole aroles) {
		this.aroles = aroles;
	}

}
