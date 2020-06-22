package com.formation.apptracking.dao;

import com.formation.apptracking.model.Activiteuser;
import com.formation.apptracking.model.Pointgps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActiviteUserRepository extends JpaRepository<Activiteuser,Long> {
    List<Activiteuser> findByIdUser(long idUser);

    List<Activiteuser> findByIdActivite(long idActivite);

    @Query("select a from Activiteuser a ")
    List<Activiteuser> getActiviteEnCours();

    @Query("select a from Activiteuser a where a.heureFin is not null and a.idUser=?1 order by a.dateActivite desc")
    List<Activiteuser> getActiviteTerminerByIdUser(Long idUser);
}