package com.cj.corona.cjcorona.domain.covidData;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CovidData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long covidId;
    private String decideCnt;
    private String clearCnt;
    private String examCnt;
    private String deathCnt;
    private String careCnt;
    private String createDt;
}
