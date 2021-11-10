package com.gutore.websitebackend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.User;
import com.gutore.websitebackend.entity.model.MCompany;
import com.gutore.websitebackend.entity.model.MUser;

@Component("mapper")
public class Mapper {

	public static List<MCompany> convertirListaCompanies(List<Company> companies){
		List<MCompany> mCompanies = new ArrayList<>();
		for(Company company: companies) {
			mCompanies.add(new MCompany(company));
		}
		return mCompanies;
	}
	
	public static List<MUser> convertirListaUsers(List<User> users){
		List<MUser> mUsers = new ArrayList<>();
		for(User user: users) {
			mUsers.add(new MUser(user));
		}
		return mUsers;
	}
}
