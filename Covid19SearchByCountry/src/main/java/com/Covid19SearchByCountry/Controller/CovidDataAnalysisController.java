package com.Covid19SearchByCountry.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Covid19SearchByCountry.CSVHelper.CSVFileReader;
import com.Covid19SearchByCountry.Entity.CovidData;
import com.Covid19SearchByCountry.Entity.USACovidData;
import com.Covid19SearchByCountry.Repository.CovidDataAnalysisRepository;
import com.Covid19SearchByCountry.Repository.USACovidDataAnalysisRepository;

/**
 * 
 * @author Suguna
 *
 */
@RestController
@RequestMapping("/api/csv")
@CrossOrigin(origins = "*")
public class CovidDataAnalysisController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(CovidDataAnalysisController.class);

	@Autowired
	USACovidDataAnalysisRepository usaCovidDataAnalysisRepository;
	
	@Autowired
	CovidDataAnalysisRepository covidDataAnalysisRepository;
	
	@Autowired
	CSVFileReader csvFileReader;
	
	/**
	 * Reading the worldwide and USA country wise covid data from two different CSV file and inserting to MYSQL DB
	 */
	@PostMapping("/upload/v1")
	public void uploadDataInDB() {
		csvFileReader.readCovidDataFromCSVFile();;
		
	}
	
	/**
	 * login authentication
	 * @return String
	 */
	@GetMapping("/")
	public String login() {
		return "authenticated successfully";
	}
	
	/**
	 * fetch the worldwide covid data from the database
	 * @return cd List<CovidData>
	 */
	@GetMapping("/fetchWHORegionData/v1")
	public ResponseEntity<List<CovidData>> fetchCovidData(){
		
		List<CovidData> cd = covidDataAnalysisRepository.findAll();
		if(null == cd || cd.isEmpty()) {
			cd = new ArrayList<CovidData>();
		}	
		return new ResponseEntity<>(cd, HttpStatus.OK);
	}
	
	@GetMapping("/fetchUSACovidData/v1")
	public ResponseEntity<List<USACovidData>> fetchUSACovidData(){
		
		List<USACovidData> usaCovidData = usaCovidDataAnalysisRepository.findAll();
		if(null == usaCovidData || usaCovidData.isEmpty()) {
			usaCovidData = new ArrayList<USACovidData>();
		}		
		return new ResponseEntity<>(usaCovidData, HttpStatus.OK);
	}
	
    @GetMapping("/fetchDataById/v1/{id}")
	public ResponseEntity<Optional<CovidData>> fetchCovidDataById(@PathVariable(value = "id") int Id){
		
		Optional<CovidData> cd = covidDataAnalysisRepository.findById(Id);
		
		return new ResponseEntity<>(cd,HttpStatus.OK);
	}
    
    
    
    
}
