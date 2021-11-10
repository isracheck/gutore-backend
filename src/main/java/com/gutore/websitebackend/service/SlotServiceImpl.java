package com.gutore.websitebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gutore.websitebackend.dao.ISlotDao;
import com.gutore.websitebackend.entity.Company;
import com.gutore.websitebackend.entity.Slot;

@Service
public class SlotServiceImpl implements ISlotService {

	@Autowired
	private ISlotDao slotDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Slot> findAll() {
		return (List<Slot>) slotDao.findAll();
	}

	@Override
	@Transactional
	public void save(Slot slot) {
		slotDao.save(slot);
		
	}


	@Override
	public void deleteSlot(Slot slot) {
		slotDao.deleteById(slot.getId());
		
	}

	@Override
	public Slot updateSlot(Slot slot) {
		return (Slot) slotDao.save(slot);
	}

	@Override
	public void deleteSlot(Long id) {
		slotDao.deleteById(id);
	}

	@Override
	public Slot findById(Long id) {
		return slotDao.findById(id).orElse(null);
	}

	
}
