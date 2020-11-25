package com.cj.corona.cjcorona.domain.covidData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidDataRepository extends JpaRepository<CovidData,Long> {
    @Query(value = "SELECT * FROM covid_data order by create_dt desc limit 2",nativeQuery = true)
    List<CovidData> findCurAndPastData();
}
