package com.formation.apptracking.dao;

import com.formation.apptracking.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteRepository extends JpaRepository<Activite,Long> {

}
