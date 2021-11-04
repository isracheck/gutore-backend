package com.gutore.websitebackend.service;

import java.util.List;

import com.gutore.websitebackend.entity.Company;

public interface ICompanyService {
	
	public List<Company> findAll();
	
	public void save(Company company);
	
	public Company findCompany(Company company);
	
	public Company checkCompanyLogin(Company company);
	
	public void deleteCompany(Company company);
	
	public Company updateCompany(Company company);
	
	public void deleteCompany(Long id);
	
	public Company findById(Long id);
	

}
