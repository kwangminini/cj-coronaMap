package com.cj.corona.cjcorona.domain.infectedPerson;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class InfectedPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infectedId;
    private String region;  //감염자 지역
    private String location;    //이동 경로 위치
    private String infectedMonth;   //감염 날짜 (월)
    private String infectedDay;     //감염 날짜 (일)
    private double latitude;    //이동 경로 위치 위도
    private double longitude;   //이동 경로 위치 경도

    @Builder
    public InfectedPerson(Long infectedId, String region, String location, String infectedMonth, String infectedDay, double latitude, double longitude) {
        this.infectedId = infectedId;
        this.region = region;
        this.location = location;
        this.infectedMonth = infectedMonth;
        this.infectedDay = infectedDay;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
