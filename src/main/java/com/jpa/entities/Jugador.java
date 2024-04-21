package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//esto quiere decir que es una tabla de la base de datos
public class Jugador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//con esto genera la clave primaria por mi
    private Long id;
    private String name;

    @Column(name = "last_name")//como se vera en la base de datos
    private String lastName;//cuando se usa camel case como en este caso cambiaremos el nombre
    private String nationality;
    private Integer age;
    private String position;//posisicion en la que juega

    //un jugador puede tener un solo equipo
    @ManyToOne(
            targetEntity = Club.class
    )
    private Club club;

}
