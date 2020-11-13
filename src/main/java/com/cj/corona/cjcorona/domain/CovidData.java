package com.cj.corona.cjcorona.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CovidData {
    @Id
    private String covidId;
    private String decideCnt;
    private String clearCnt;
    private String examCnt;
    private String deathCnt;
    private String careCnt;
    private String createDt;
}
