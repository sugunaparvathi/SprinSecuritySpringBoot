package com.Covid19SearchByCountry.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String country;
	private long confirmedCases;
	private long confirmedDeaths;
	private long recoveredCases;
	private long activeCases;
	private long newCases;
	private long newDeaths;
	private long newRecovered;
	private long confirmedLastWeek;
	private String whoRegion;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getConfirmedCases() {
		return confirmedCases;
	}
	public void setConfirmedCases(long confirmedCases) {
		this.confirmedCases = confirmedCases;
	}
	public long getConfirmedDeaths() {
		return confirmedDeaths;
	}
	public void setConfirmedDeaths(long confirmedDeaths) {
		this.confirmedDeaths = confirmedDeaths;
	}
	public long getRecoveredCases() {
		return recoveredCases;
	}
	public void setRecoveredCases(long recoveredCases) {
		this.recoveredCases = recoveredCases;
	}
	public long getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(long activeCases) {
		this.activeCases = activeCases;
	}
	public long getNewCases() {
		return newCases;
	}
	public void setNewCases(long newCases) {
		this.newCases = newCases;
	}
	public long getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(long newDeaths) {
		this.newDeaths = newDeaths;
	}
	public long getNewRecovered() {
		return newRecovered;
	}
	public void setNewRecovered(long newRecovered) {
		this.newRecovered = newRecovered;
	}
	public long getConfirmedLastWeek() {
		return confirmedLastWeek;
	}
	public void setConfirmedLastWeek(long confirmedLastWeek) {
		this.confirmedLastWeek = confirmedLastWeek;
	}
	public String getWhoRegion() {
		return whoRegion;
	}
	public void setWhoRegion(String whoRegion) {
		this.whoRegion = whoRegion;
	}
	public CovidData(long id, String country, long confirmedCases, long confirmedDeaths, long recoveredCases,
			long activeCases, long newCases, long newDeaths, long newRecovered, long confirmedLastWeek, String whoRegion) {
		super();
		Id = id;
		this.country = country;
		this.confirmedCases = confirmedCases;
		this.confirmedDeaths = confirmedDeaths;
		this.recoveredCases = recoveredCases;
		this.activeCases = activeCases;
		this.newCases = newCases;
		this.newDeaths = newDeaths;
		this.newRecovered = newRecovered;
		this.confirmedLastWeek = confirmedLastWeek;
		this.whoRegion = whoRegion;
	}
	public CovidData() {
		// TODO Auto-generated constructor stub
	}
	 
	
	}
