package com.gutore.websitebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gutore.websitebackend.dao.IUserDao;
import com.gutore.websitebackend.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(User user) {
		return (User) userDao.findByEmail(user.getEmail());
	}

	@Override
	public User checkUserLogin(User user) {
		return (User) userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteByUser(user.getUser());	
	}

	@Override
	public User updateUser(User user) {
		return (User) userDao.save(user);
	}

	@Override
	public void deleteUser(String user) {
		userDao.deleteByUser(user);	
	}

	@Override
	public User findByUser(String user) {
		return (User) userDao.findByUser(user);
	}



}
