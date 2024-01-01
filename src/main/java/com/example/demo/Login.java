package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.text.DateFormat;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="login")
public class Login {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;
    private String institutionalEmail;

    private Date date_naissance;
    ;
    private String filiere;



//    public Login()
//    {}



    /*public Login(Long id, String username, String mdp,String institutionalEmail,DateFormat date) {

        this.id = id;
        this.username = username;
        this.password = mdp;
        this.institutionalEmail=institutionalEmail;
        this.date_naissance=date;
    }*/

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInstitutionalEmail(String institutionalEmail) {
        this.institutionalEmail = institutionalEmail;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }


}