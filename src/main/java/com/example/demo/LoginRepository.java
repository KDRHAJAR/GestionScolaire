package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    List<Login> findByUsernameAndPassword(String username, String password);

    Login findByInstitutionalEmail(String email);
}



