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

import com.gutore.websitebackend.entity.Slot;
import com.gutore.websitebackend.mapper.Mapper;
import com.gutore.websitebackend.service.ISlotService;

@RestController
@RequestMapping("/api/slots")
public class SlotRestController {
	
	@Autowired
	private ISlotService slotService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Slot> getCompanies(){
		return slotService.findAll();
	}
	
	@PostMapping("/findSlot/{id}")
	public ResponseEntity<?> findSlot(@PathVariable(value="id")Long id){
		Slot slotDb = slotService.findById(id);
		if(slotDb!=null) {
			return new ResponseEntity<>(slotDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Void> addSlot(@RequestBody Slot slot){
		
			slotService.save(slot);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateSlot(@PathVariable(value="id")Long id, @RequestBody Slot slot){
		Slot slotDb = null;
		slotDb = slotService.findById(id);
		if(slotDb != null) {
			slotDb.setDay(slot.getDay());
			slotDb.setInitialHour(slot.getInitialHour());
			slotDb.setFinalHour(slot.getFinalHour());
			slotDb.setNumberSlots(slot.getNumberSlots());
			slotService.updateSlot(slot);
			return new ResponseEntity<>(slotDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSlot(@PathVariable(value="id")Long id){
		slotService.deleteSlot(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
