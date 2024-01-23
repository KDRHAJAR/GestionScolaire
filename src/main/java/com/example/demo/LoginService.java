package com.example.demo;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional


public class LoginService {

    @Autowired
    private LoginRepository repo;
    public Login login(String username, String password) {
        List<Login> users = repo.findByUsernameAndPassword(username, password);

        if (users.isEmpty()) {
            // Handle case when no user is found
            return null;
        } else if (users.size() == 1) {
            // Return the single user found
            return users.get(0);
        } else {
            // Handle case when multiple users are found (log, throw exception, etc.)
            throw new RuntimeException("Multiple users found for username and password");
        }
    }

    //njebdou chi 7aja men base donne
    //save update les fonctionalite crud
    public Login findByEmail(String email) {
        Login user = repo.findByInstitutionalEmail(email);
        return user;
    }

    public void save(Login user) {
        repo.save(user);
    }



}