package com.itlize.marketBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int BuyerID;
//	private boolean isLogin;
	@Column
	private String username;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String password;
	
	private transient String message;

	public int getBuyerID() {
		return BuyerID;
	}

	public void setBuyerID(int buyerID) {
		BuyerID = buyerID;
	}

//	public boolean isLogin() {
//		return isLogin;
//	}
//
//	public void setLogin(boolean isLogin) {
//		this.isLogin = isLogin;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
