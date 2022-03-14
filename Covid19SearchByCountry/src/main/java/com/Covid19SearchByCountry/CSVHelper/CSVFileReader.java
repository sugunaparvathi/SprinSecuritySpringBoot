package com.Covid19SearchByCountry.CSVHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Covid19SearchByCountry.Entity.CovidData;
import com.Covid19SearchByCountry.Entity.USACovidData;
import com.Covid19SearchByCountry.Repository.CovidDataAnalysisRepository;
import com.Covid19SearchByCountry.Repository.USACovidDataAnalysisRepository;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Suguna
 * 
 * fetch the worldwide and USA country wise covid data from the MySQL database
 *
 */
@Service
@Slf4j
public class CSVFileReader {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(CSVFileReader.class);


	String line = "";

	@Autowired
	CovidDataAnalysisRepository covidDataAnalysisRepository;

	@Autowired
	USACovidDataAnalysisRepository usaCovidDataAnalysisRepository;

	/**
	 * 
	 */
	public void readCovidDataFromCSVFile() {

		readWorldWideCovidData("src/main/resources/country_wise_latest.csv");
		readUSACovidData("src/main/resources/usa_county_wise_updated.csv");
	}

	/**
	 * 
	 * @param filePath String
	 */
	private void readWorldWideCovidData(String filePath) {

		try {
			covidDataAnalysisRepository.deleteAll();
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath));
			int i = 0;
			while ((line = bufferReader.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				}
				String[] data = line.split(",");
				CovidData cd = new CovidData();
				if(null != data && data.length != 0) {
					cd.setCountry(data[0]);
					cd.setConfirmedCases(convertStrLong(data[1]));
					cd.setConfirmedDeaths(convertStrLong(data[2]));
					cd.setRecoveredCases(convertStrLong(data[3]));
					cd.setActiveCases(convertStrLong(data[4]));
					cd.setNewCases(convertStrLong(data[5]));
					cd.setNewDeaths(convertStrLong(data[6]));
					cd.setNewRecovered(convertStrLong(data[7]));
					cd.setConfirmedLastWeek(convertStrLong(data[8]));
					cd.setWhoRegion(data[9]);
					covidDataAnalysisRepository.save(cd);
				}
				
			}
		} catch (IOException io) {
			log.error("Exception occured while reading the worldwide covid data file and saving to DB" + io.getMessage());
		}
	}

	/**
	 * 
	 * @param filePath String
	 * 
	 */
	private void readUSACovidData(String filePath) {

		try {
			
			usaCovidDataAnalysisRepository.deleteAll();
			
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			int i = 0;
			String usaLineData = "";
			while ((usaLineData = br.readLine()) != null) {
				if (i == 0) {
					i++;
					continue;
				}
				String[] data = usaLineData.split(",");
				if(null != data && data.length != 0) {
 					int length = data.length;
					USACovidData usaCd = new USACovidData();

					usaCd.setCountyName((data[0]));
	 				usaCd.setStateName(data[1]);
 	 				usaCd.setDate(data[2]);
	 				usaCd.setNoOfConfirmed(data[3]);
 					if(length == 5) { 
		 				usaCd.setNoOfDeath(data[4]); 
					} else {
		 				usaCd.setNoOfDeath("0");  
					} 
					usaCovidDataAnalysisRepository.save(usaCd);

				}  
 			}
		} catch (IOException io) { 
			log.error("Exception occured while reading the USA covid data file and saving to DB" + io.getMessage());
		}
	}

	private Long convertStrLong(String input) {
		return (!input.isBlank()) ? Long.valueOf(input) : null;
	}
}