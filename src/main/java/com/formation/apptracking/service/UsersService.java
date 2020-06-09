package com.formation.apptracking.service;

import com.formation.apptracking.dao.GenreRepository;
import com.formation.apptracking.dao.UsersRepository;
import com.formation.apptracking.dto.UserDto;
import com.formation.apptracking.model.Genre;
import com.formation.apptracking.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UsersService {
  private final UsersRepository userRepo;
  private final GenreRepository genreRepo;
    @Autowired
    public UsersService(UsersRepository userRepo,GenreRepository genreRepo) {
        this.userRepo = userRepo;
        this.genreRepo=genreRepo;
    }

    @Transactional
    public UserDto saveUser(UserDto user,String profil){
        try {
            Genre g=this.genreRepo.findById(user.getIdGenre()).orElseThrow(()
                    -> new EntityNotFoundException(String.format("Id du genre selectionner n'existe pas dans la base: ",user.getIdGenre())));
            Users u= new Users();
            u.setNomUser(user.getNomUser());
            u.setAdresseUser(user.getAdresseUser());
            u.setAgeUser(user.getAgeUser());
            u.setPrenomUser(user.getPrenomUser());
            u.setIdGenre(g.getIdGenre());
            u.setLogin(user.getLogin());
            u.setPwd(user.getPwd());
            u.setProfil(profil);
            this.userRepo.save(u);
            return user;
        }catch (Exception ex){
            System.err.println("erreur lors de l'ajout d'un nouveau utilisateur"+ ex.getMessage());
            return user;
        }

   }

   public UserDto getConnexionByCredential(String login,String pwd){
    try {
        Users u=this.userRepo.getUserByLogAndPass(login,pwd).orElseThrow(()
                -> new EntityNotFoundException(String.format("Utilisateur introuvable: ")));

        return toUsersDto(u);
    }catch (Exception ex){
        return null;
    }

   }

    public UserDto getUserAdminByLogAndPass(String login,String pwd){
        try {
            Users u=this.userRepo.getUserAdminByLogAndPass(login,pwd,"ADMIN").orElseThrow(()
                    -> new EntityNotFoundException(String.format("Utilisateur introuvable: ")));

            return toUsersDto(u);
        }catch (Exception ex){
            return null;
        }

    }

    public  UserDto toUsersDto(Users u){
        UserDto uti=new UserDto();
        uti.setIdUser(u.getIdUser());
        uti.setAdresseUser(u.getAdresseUser());
        uti.setAgeUser(u.getAgeUser());
        uti.setIdGenre(u.getIdGenre());
        uti.setLogin(u.getLogin());
        uti.setProfil(u.getProfil());
        uti.setPwd(u.getPwd());
        return uti;
    }
}
