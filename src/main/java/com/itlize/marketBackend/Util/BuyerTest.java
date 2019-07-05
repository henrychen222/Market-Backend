//package com.itlize.marketBackend.Util;
//
//import java.util.List;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
//
//@XmlRootElement(name = "Buyers")
//@XmlType(propOrder = { "BuyerID", "Username", "Password", "Email","FirstName","LastName"})
//public class BuyerTest {
//	private List<String> BuyerID;
//	private List<String> Username;
//	private List<String> Password;
//	private List<String> Email;
//	private List<String> FirstName;
//	private List<String> LastName;
//	
//	@XmlElementWrapper(name = "Buyer")
//	@XmlElement(name = "BuyerID")
//	public List<String> getBuyerID() {
//		return BuyerID;
//	}
//
//	public void setBuyerID(List<String> buyerID) {
//		BuyerID = buyerID;
//	}
//
//	@XmlElementWrapper(name = "Buyer")
//	@XmlElement(name = "Username")
//	public List<String> getUsername() {
//		return Username;
//	}
//
//	public void setUsername(List<String> username) {
//		Username = username;
//	}
//
//	@XmlElementWrapper(name = "Buyer")
//	@XmlElement(name = "Password")
//	public List<String> getPassword() {
//		return Password;
//	}
//
//	public void setPassword(List<String> password) {
//		Password = password;
//	}
//
//	@XmlElementWrapper(name = "Buyer")
//	@XmlElement(name = "Email")
//	public List<String> getEmail() {
//		return Email;
//	}
//
//	public void setEmail(List<String> email) {
//		Email = email;
//	}
//
//	@XmlElementWrapper(name = "Buyer")
//	@XmlElement(name = "FirstName")
//	public List<String> getFirstName() {
//		return FirstName;
//	}
//
//	public void setFirstName(List<String> firstName) {
//		FirstName = firstName;
//	}
//
//	@XmlElementWrapper(name = "Buyer")
//	@XmlElement(name = "LastName")
//	public List<String> getLastName() {
//		return LastName;
//	}
//
//	public void setLastName(List<String> lastName) {
//		LastName = lastName;
//	}
//
//	
//
//}
