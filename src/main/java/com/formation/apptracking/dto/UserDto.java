package com.formation.apptracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty("idUser")
    private Long  idUser;

    @JsonProperty("prenomUser")
    private String prenomUser;

    @JsonProperty("nomUser")
    private String nomUser;

    @JsonProperty("adresseUser")
    private String adresseUser;

    @JsonProperty("ageUser")
    private int ageUser;

    @JsonProperty("login")
    private String login;

    @JsonProperty("pwd")
    private String pwd;

    @JsonProperty("idGenre")
    private long idGenre;

    @JsonProperty("profil")
    private String profil;

}
