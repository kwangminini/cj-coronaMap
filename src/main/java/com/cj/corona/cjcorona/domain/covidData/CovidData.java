package com.cj.corona.cjcorona.domain.covidData;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class CovidData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long covidId;
    private int decideCnt;
    private int clearCnt;
    private int examCnt;
    private int deathCnt;
    private int careCnt;
    private LocalDateTime createDt;

    @Builder
    public CovidData(Long covidId, int decideCnt, int clearCnt, int examCnt, int deathCnt, int careCnt, LocalDateTime createDt) {
        this.covidId = covidId;
        this.decideCnt = decideCnt;
        this.clearCnt = clearCnt;
        this.examCnt = examCnt;
        this.deathCnt = deathCnt;
        this.careCnt = careCnt;
        this.createDt = createDt;
    }
}
