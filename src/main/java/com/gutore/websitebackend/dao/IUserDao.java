package com.gutore.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

	public User findByEmail(String email);
	
	public User findByUser(String user);
	
	public User findByEmailAndPassword(String email, String password);
	
	public User deleteByUser(String user);
}
