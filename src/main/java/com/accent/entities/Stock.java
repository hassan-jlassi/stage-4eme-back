package com.accent.entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idProduit;
    private String numSerie;
    private int IMEI;
    private Date dateProduction;
    private String categorie;

}
