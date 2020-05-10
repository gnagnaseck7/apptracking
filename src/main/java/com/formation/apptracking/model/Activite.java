package com.formation.apptracking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "activite")
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idActivite")
    private long idActivite;

    @Column(name = "libelleActivite")
    private String libelleActivite;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Activiteuser> listActiviteUserByActivity;
}
