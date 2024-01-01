package com.example.demo;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional


public class LoginService {

    @Autowired
    private LoginRepository repo;

    public Login login(String username, String password) {
        Login user = repo.findByUsernameAndPassword(username, password);
        return user;
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