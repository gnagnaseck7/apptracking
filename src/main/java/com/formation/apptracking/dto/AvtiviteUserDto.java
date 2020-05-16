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
public class AvtiviteUserDto {

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

}
