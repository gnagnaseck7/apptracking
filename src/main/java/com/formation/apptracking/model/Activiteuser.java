package com.formation.apptracking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Data
@Entity
@Table(name = "activiteuser")
public class Activiteuser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idActiviteUser")
    private Long idActiviteUser;

    @Column(name = "dateActivite")
    @Temporal(TemporalType.DATE)
    private Date dateActivite;

    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;

    @Column(name = "heureFin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;

    @Column(name = "valide")
    private Character valide;

    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "idActivite")
    private Long idActivite;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Pointgps> listPointGpsActivite;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUser",referencedColumnName = "idUser",insertable = false, updatable = false)
    private Users users;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idActivite",referencedColumnName = "idActivite",insertable = false, updatable = false)
    private Activite activite;


}
