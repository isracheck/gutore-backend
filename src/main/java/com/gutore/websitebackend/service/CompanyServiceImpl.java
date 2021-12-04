package com.gutore.websitebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gutore.websitebackend.dao.ICompanyDao;
import com.gutore.websitebackend.entity.Company;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Company> findAll() {
		return (List<Company>) companyDao.findAll();
	}

	@Override
	@Transactional
	public void save(Company company) {
		companyDao.save(company);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Company findCompany(Company company) {
		return (Company) companyDao.findByEmail(company.getEmail());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Company> findCompanyByName(String name) {
		return (List<Company>) companyDao.findByName(name);
	}

	@Override
	public Company checkCompanyLogin(Company company) {
		return (Company) companyDao.findByEmailAndPassword(company.getEmail(), company.getPassword());
	}

	@Override
	public void deleteCompany(Company company) {
		companyDao.deleteById(company.getIdCompany());
		
	}

	@Override
	public Company updateCompany(Company company) {
		return (Company) companyDao.save(company);
	}

	@Override
	public void deleteCompany(Long id) {
		companyDao.deleteById(id);
	}

	@Override
	public Company findById(Long id) {
		return companyDao.findById(id).orElse(null);
	}

}
