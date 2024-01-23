package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;


import java.sql.Date;
import java.text.DateFormat;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="professor")
public class Professor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;

    private String matiere;

    private String username;
    private String password;

    // Getters and setters...

}
