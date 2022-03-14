package com.Covid19SearchByCountry.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class USACovidData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
 	private String countyName;
	private String stateName;
 	private String date;
	private String noOfConfirmed;
	private String noOfDeath;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNoOfConfirmed() {
		return noOfConfirmed;
	}
	public void setNoOfConfirmed(String noOfConfirmed) {
		this.noOfConfirmed = noOfConfirmed;
	}
	public String getNoOfDeath() {
		return noOfDeath;
	}
	public void setNoOfDeath(String noOfDeath) {
		this.noOfDeath = noOfDeath;
	}  

}
