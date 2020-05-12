package com.formation.apptracking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pointgps")
public class Pointgps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPoint")
    private long idPoint;

    @Column(name = "heure")
    @Temporal(TemporalType.TIME)
    private Date heure;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "idActiviteUser")
    private int idActiviteUse;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idActiviteUser",referencedColumnName = "idActiviteUser",insertable = false, updatable = false)
    private Activiteuser activiteuser;

}
