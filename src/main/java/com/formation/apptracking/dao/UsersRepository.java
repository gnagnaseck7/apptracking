package com.formation.apptracking.dao;

import com.formation.apptracking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("select u from Users u where u.login=?1 and u.pwd=?2")
    Optional<Users> getUserByLogAndPass(String login,String pwd);

    @Query("select u from Users u where u.login=?1 and u.pwd=?2 and u.profil=?3")
    Optional<Users> getUserAdminByLogAndPass(String login,String pwd,String profil);
}
