package com.gutore.websitebackend.service;

import java.util.List;

import com.gutore.websitebackend.entity.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public void save(User user);
	
	public User findUser(User user);
	
	public User findByUser(String user);
	
	public User checkUserLogin(User user);
	
	public void deleteUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(String user);
	

}
