package com.gutore.websitebackend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="gousers")
public class User implements Serializable {
	
	@Id
	@Column(length = 100, unique = true)
	private String user;

	@Column(length = 60, unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Column (name="lastname")
	private String lastName;
	
	@Column(nullable = false)
	private String phone;
	

	private String photo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", referencedColumnName = "user")
	private List<Slot> slot = new ArrayList<>();
	
	
	








	public String getUser() {
		return user;
	}





	public void setUser(String user) {
		this.user = user;
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





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getPhone() {
		return phone;
	}





	public void setPhone(String phone) {
		this.phone = phone;
	}





	public String getPhoto() {
		return photo;
	}





	public void setPhoto(String photo) {
		this.photo = photo;
	}





	public List<Slot> getSlot() {
		return slot;
	}





	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}





	private static final long serialVersionUID = 1L;
}
