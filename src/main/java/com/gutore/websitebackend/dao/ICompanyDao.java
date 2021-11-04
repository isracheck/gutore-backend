package com.gutore.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.gutore.websitebackend.entity.Company;

public interface ICompanyDao extends CrudRepository<Company, Long>{

	public Company findByEmail(String email);
	
	public Company findByDocNumber(String docNumber);
	
	public Company findByEmailAndPassword(String email, String password);
}
