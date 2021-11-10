package com.gutore.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.Slot;

public interface ISlotDao extends CrudRepository<Slot, Long>{


}
