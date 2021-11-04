package com.gutore.websitebackend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gocompany")
public class Company implements Serializable {

	@Id
	@Column(name = "idcompany")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompany;

	@Column(nullable = false)
	private String name;

	@Column(name = "docnumber", unique = true, nullable = false)
	private String docNumber;

	@Column(name = "doctype", nullable = false)
	private String docType;

	private String logo;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String pass;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcompany", referencedColumnName = "idcompany")
	@Column(nullable = false)
	private List<Slot> slot = new ArrayList<>();

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Slot> getSlot() {
		return slot;
	}

	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}

	private static final long serialVersionUID = 1L;
}
