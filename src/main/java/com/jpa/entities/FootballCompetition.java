package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//esto quiere decir que es una tabla de la base de datos
public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//con esto genera la clave primaria por mi
    private Long id;
    private String name;
    @Column(name = "cuantity_price")
    private Integer cuantityPrice;
    @Column(name = "start_date", columnDefinition = "Date")//especifiacndo el tipo de dato que tendra en la tabla
    private LocalDate startDate;
    @Column(name = "end_date", columnDefinition = "Date")
    private LocalDate endDate;





}
