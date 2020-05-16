package com.formation.apptracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiviteDto {
    @JsonProperty("idActivite")
    private long idActivite;

    @JsonProperty("libelleActivite")
    private String libelleActivite;
}
