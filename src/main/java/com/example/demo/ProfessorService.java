package com.example.demo;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class ProfessorService {



        @Autowired
        private ProfessorRepository repo;

    public Professor login(String username, String password) {
        Professor user = repo.findByUsernameAndPassword(username, password);
        return user;
    }



    }
