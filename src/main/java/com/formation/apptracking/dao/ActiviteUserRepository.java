package com.formation.apptracking.dao;

import com.formation.apptracking.model.Activiteuser;
import com.formation.apptracking.model.Pointgps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteUserRepository extends JpaRepository<Activiteuser,Long> {
}
