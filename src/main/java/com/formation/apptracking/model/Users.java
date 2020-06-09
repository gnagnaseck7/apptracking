package com.formation.apptracking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser")
    private Long  idUser;

    @Column(name = "prenomUser")
    private String prenomUser;

    @Column(name = "nomUser")
    private String nomUser;

    @Column(name = "adresseUser")
    private String adresseUser;

    @Column(name = "ageUser")
    private int ageUser;

    @Column(name = "login")
    private String login;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "idGenre")
    private Long idGenre;

    @Column(name = "profil")
    private String profil;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idGenre",referencedColumnName = "idGenre",insertable = false, updatable = false)
    private Genre genre;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Activiteuser> listActiviteOneUser;


}
