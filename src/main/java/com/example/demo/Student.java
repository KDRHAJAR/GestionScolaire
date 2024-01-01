package com.example.demo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class Student {
    private int cne;
    private String nom;
    private String prenom;
    private String filiere;
    private Date Date_Inscreption;

}
