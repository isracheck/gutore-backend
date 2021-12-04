package com.gutore.websitebackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gutore.websitebackend.entity.Company;

public interface ICompanyDao extends CrudRepository<Company, Long>{

	public Company findByEmail(String email);
	
	@Query("select p from Company p where p.name like %?1%")
	public List<Company> findByName(String name);
	
	public Company findByDocNumber(String docNumber);
	
	public Company findByEmailAndPassword(String email, String password);
}
