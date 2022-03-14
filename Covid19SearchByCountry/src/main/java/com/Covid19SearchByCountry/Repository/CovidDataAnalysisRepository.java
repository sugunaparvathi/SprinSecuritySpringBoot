package com.Covid19SearchByCountry.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Covid19SearchByCountry.Entity.CovidData;

@Repository
public interface CovidDataAnalysisRepository extends JpaRepository<CovidData, Integer> {

}
