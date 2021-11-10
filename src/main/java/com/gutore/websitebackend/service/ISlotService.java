package com.gutore.websitebackend.service;

import java.util.List;

import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.Slot;

public interface ISlotService {
	
	public List<Slot> findAll();
	
	public void save(Slot slot);
	
	public void deleteSlot(Slot slot);
	
	public Slot updateSlot(Slot slot);
	
	public void deleteSlot(Long id);
	
	public Slot findById(Long id);
	
	

}
