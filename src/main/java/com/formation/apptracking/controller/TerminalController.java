package com.formation.apptracking.controller;

import com.formation.apptracking.dto.ActiviteDto;
import com.formation.apptracking.dto.AvtiviteUserDto;
import com.formation.apptracking.dto.PointGpsDto;
import com.formation.apptracking.dto.UserDto;
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

    @PostMapping("/ajouterActiviteUser")
    public AvtiviteUserDto ajouterActiviteSportive(
            @RequestBody AvtiviteUserDto newActivite) {
        return this.activiteServ.saveNewUserActivite(newActivite);
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



}
