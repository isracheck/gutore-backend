package com.gutore.websitebackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.model.MCompany;
import com.gutore.websitebackend.mapper.Mapper;
import com.gutore.websitebackend.service.ICompanyService;

@RestController
@RequestMapping("/api")
public class CompanyRestController {
	
	@Autowired
	private ICompanyService companyService;
	
	@GetMapping("/companies")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getCompanies(){
		return companyService.findAll();
	}
	
	@PostMapping("/findCompany")
	public ResponseEntity<?> findCompany(@RequestBody Company company){
		Company companyDb = companyService.findCompany(company);
		if(companyDb!=null) {
			return new ResponseEntity<>(companyDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<Void> addCompany(@RequestBody Company company){
		if(companyService.findCompany(company)==null) {
			companyService.save(company);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("login")
	public ResponseEntity<?> loginCompany(@RequestBody Company company){
		Company companyDb = companyService.checkCompanyLogin(company);
		if(companyDb!=null) {
			List<Company> companies = new ArrayList<>();
			companies.add(companyDb);
			List<MCompany> mCompanies = new ArrayList<>();
			mCompanies = Mapper.convertirLista(companies);
			return new ResponseEntity<>(mCompanies, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCompany(@PathVariable(value="id")Long id, @RequestBody Company company){
		Company companyDb = null;
		companyDb = companyService.findById(id);
		if(companyDb != null) {
			companyDb.setEmail(company.getEmail());
			companyDb.setName(company.getName());
			companyDb.setLogo(company.getLogo());
			companyService.updateCompany(company);
			return new ResponseEntity<>(companyDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable(value="id")Long id){
		companyService.deleteCompany(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
