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
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//con esto genera la clave primaria por mi
    private Long id;
    private String name;

    //1 a 1
    //en este caso tendremos la clave foranea aqui en el club
    //con esto le decimos que la relacion  sera de uno a uno
    @OneToOne(
            targetEntity = Entrenador.class,//la relacion se hara con esta clase
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "id_entrenador")//cambiamos el nombre de la clave foranea
    private Entrenador entrenador;


    //1  a M
    //un equipo tiene muchos jugadores o sea un listado de jugadores
    //siempre inicia con la relacion que tenga la entidad uno
    @OneToMany(
            targetEntity = Jugador.class,
            fetch = FetchType.LAZY,
            mappedBy = "club"

    )
    private List<Jugador> jugadores;


    //M a 1
    // muchos equipos pertenecen a una sola federacion
    @ManyToOne(targetEntity = FootballAssociation.class)
    private FootballAssociation footballAssociation;


    //M a M
    //un club puede jugar en muchas competiciones
    @ManyToMany(targetEntity = FootballCompetition.class , fetch = FetchType.LAZY)
    @JoinTable(name = "club_competition", joinColumns = @JoinColumn(name = "id_club") ,inverseJoinColumns = @JoinColumn(name = "id_competition") )
    private List<FootballCompetition> footballCompetitions;






}
