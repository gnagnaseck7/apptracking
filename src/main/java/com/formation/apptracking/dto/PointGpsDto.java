package com.formation.apptracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointGpsDto {
    @JsonProperty("idPoint")
    private long idPoint;

    @JsonProperty("heure")
    private Date heure;

    @Column(name = "latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("idActiviteUser")
    private long idActiviteUser;
}
