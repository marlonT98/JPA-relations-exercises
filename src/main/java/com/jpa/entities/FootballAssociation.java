package com.jpa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//esto quiere decir que es una tabla de la base de datos
public class FootballAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//con esto genera la clave primaria por mi
    private Long id;
    private String name;
    private String country;
    private String president;

    //1 a  M
    // una federacion tiene muchos equipos
    //mappedBy: recuerda en una relacion de (1 a m) o (m a 1),  la entidad que contiene el 1 debe de pasar
    //como clave foranea a la tabla que contiene la relacion de muchos.
    //club es muchos
    //asociacion es uno
    //por lo tanto esto "footballAssociation" debe de ser la clave foranea
    @OneToMany(targetEntity = Club.class , fetch = FetchType.LAZY , mappedBy = "footballAssociation")
    private List<Club> clubs;



}
