package com.formation.apptracking.controller;

import com.formation.apptracking.dto.*;
import com.formation.apptracking.service.ActiviteUserService;
import com.formation.apptracking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TerminalController extends ApptrackingBaseController{

    private final UsersService userServ;
    private final ActiviteUserService activiteServ;

    @Autowired
    public TerminalController(UsersService userServ,ActiviteUserService activiteServ) {
        this.userServ = userServ;
        this.activiteServ=activiteServ;
    }


    /**
     * creerUtilistateur
     *
     * @param_UserDto
     * @return User created DTO
     */
    @PostMapping("/creerUtilistateur")
    public UserDto ajouterUtilisateur(
            @RequestBody UserDto userReceive) {
        return this.userServ.saveUser(userReceive,"UTI");
    }

    @PostMapping("/getConnexion")
    public UserDto getConnexion( @RequestBody CredentialDto key) {
        return this.userServ.getConnexionByCredential(key.getLogin(),key.getPwd());
    }

    @PostMapping("/getConnexionAdmin")
    public UserDto getConnexionAdmin( @RequestBody CredentialDto key) {
        return this.userServ.getUserAdminByLogAndPass(key.getLogin(),key.getPwd());
    }

    @PostMapping("/ajouterActiviteUser")
    public AvtiviteUserDto ajouterActiviteSportive(
            @RequestBody AvtiviteUserDto newActivite) {
        return this.activiteServ.saveNewUserActivite(newActivite);
    }

    @PostMapping("/updateActiviteUser")
    public AvtiviteUserDto updateActiviteUser(
            @RequestBody AvtiviteUserDto newActivite) {
        return this.activiteServ.UpdateUserActivite(newActivite);
    }

    @PostMapping("/ajouterPointGps")
    public PointGpsDto ajouterUnPointDeActivite(
            @RequestBody PointGpsDto newPointPourActivite) {
        return this.activiteServ.saveNewPointGpsPourActivite(newPointPourActivite);
    }

    @GetMapping("/getListeActivite")
    public List<ActiviteDto> getListeAllActivite(){
        return  this.activiteServ.getListeAllActivite();
    }

    @GetMapping("/getListeAllActiviteByUser/{idUser}")
    public List<ActiviteUserDtoRetour> getListeAllActiviteByUser(@PathVariable("idUser") Long idUser){
        return  this.activiteServ.getListeActiviteUserByIdUser(idUser);
    }

    @GetMapping("/getListeAllActiviteEncours")
    public List<ActiviteUserDtoRetour> getListeAllActiviteByUser(){
        return  this.activiteServ.getAllActiviteEnCours();
    }

    @GetMapping("/getListePointByIdActivite/{idActivite}")
    public List<PointGpsDto> getListePointByIdActivite(@PathVariable("idActivite") Long idActivite){
        return  this.activiteServ.getListePointGpsByIdActiviteUser(idActivite);
    }




}
