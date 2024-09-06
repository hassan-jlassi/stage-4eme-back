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
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idVente;

    private Date dateVente;
    private double montantTotal;
    private String produit;
    private String client;
}
