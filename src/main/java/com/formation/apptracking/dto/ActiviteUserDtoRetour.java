package com.formation.apptracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiviteUserDtoRetour {
    @JsonProperty("idActiviteUser")
    private long idActiviteUser;

    @JsonProperty("dateActivite")
    private Date dateActivite;

    @JsonProperty("heureDebut")
    private Date heureDebut;

    @JsonProperty("heureFin")
    private Date heureFin;

    @JsonProperty("valide")
    private Character valide;

    @JsonProperty("idUser")
    private long idUser;

    @JsonProperty("idActivite")
    private long idActivite;

    @JsonProperty("libelleActivite")
    private String libelleActivite;

    @JsonProperty("listPointGps")
    private List<PointGpsDto> listPointGps;

    @JsonProperty("prenomNomUser")
    private String prenomNomUser;

}
