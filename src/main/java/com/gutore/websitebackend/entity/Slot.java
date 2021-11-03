package com.gutore.websitebackend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="goslots")
public class Slot implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date day;
	
	@Column (name="ihour", nullable = false)
	private Date initialHour;
	
	@Column (name="fhour", nullable = false)
	private Date finalHour;
	
	@Column (name="slots", nullable = false)
	private Integer numberSlots;
	
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Date getDay() {
		return day;
	}




	public void setDay(Date day) {
		this.day = day;
	}




	public Date getInitialHour() {
		return initialHour;
	}




	public void setInitialHour(Date initialHour) {
		this.initialHour = initialHour;
	}




	public Date getFinalHour() {
		return finalHour;
	}




	public void setFinalHour(Date finalHour) {
		this.finalHour = finalHour;
	}




	public Integer getNumberSlots() {
		return numberSlots;
	}




	public void setNumberSlots(Integer numberSlots) {
		this.numberSlots = numberSlots;
	}




	private static final long serialVersionUID = 1L;
}
