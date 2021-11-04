package com.gutore.websitebackend.entity.model;

import com.gutore.websitebackend.entity.Company;

public class MCompany {
	private Long id;
	private String name;
	private String email;
	private String logo;
	
	
	public MCompany() {
		
	}
	
	
	public MCompany(Long id, String name, String email, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.logo = logo;
	}

	
	public MCompany(Company company) {
		this.id = company.getIdCompany();
		this.name = company.getName();
		this.email = company.getEmail();
		this.logo = company.getLogo();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
