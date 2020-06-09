package com.formation.apptracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDto {
    @JsonProperty("login")
    private String login;

    @JsonProperty("pwd")
    private String pwd;
}
