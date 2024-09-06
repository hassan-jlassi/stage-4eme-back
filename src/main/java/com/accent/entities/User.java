package com.accent.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idUser;

    private String nomUser;
    private String prenomUser;
    private String emailUser;
    private String passwordUser;
    private String role;
    private String departement;

}
