package com.formation.apptracking.dao;


import com.formation.apptracking.model.Pointgps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointGpsRepository extends JpaRepository<Pointgps,Long> {
   List<Pointgps> findPointgpsByIdActiviteUser(Long idActiviteUser);
}
