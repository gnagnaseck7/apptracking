package com.formation.apptracking.dao;

import com.formation.apptracking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

}
