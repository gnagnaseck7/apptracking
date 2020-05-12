package com.formation.apptracking.controller;

import com.formation.apptracking.dto.UserDto;
import com.formation.apptracking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TerminalController extends ApptrackingBaseController{

    private final UsersService userServ;

    @Autowired
    public TerminalController(UsersService userServ) {
        this.userServ = userServ;
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
      return this.userServ.saveUser(userReceive);
    }



}
