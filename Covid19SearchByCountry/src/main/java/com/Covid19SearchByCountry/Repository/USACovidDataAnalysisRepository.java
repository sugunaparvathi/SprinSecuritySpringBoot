package com.Covid19SearchByCountry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Covid19SearchByCountry.Entity.CovidData;
import com.Covid19SearchByCountry.Entity.USACovidData;

@Repository
public interface USACovidDataAnalysisRepository extends JpaRepository<USACovidData, Long> {

}
