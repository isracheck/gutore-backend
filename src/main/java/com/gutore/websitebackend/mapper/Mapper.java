package com.gutore.websitebackend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.model.MCompany;

@Component("mapper")
public class Mapper {

	public static List<MCompany> convertirLista(List<Company> companies){
		List<MCompany> mCompanies = new ArrayList<>();
		for(Company company: companies) {
			mCompanies.add(new MCompany(company));
		}
		return mCompanies;
	}
}
