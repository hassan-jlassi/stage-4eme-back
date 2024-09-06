package com.accent.services;

import com.accent.entities.Composant;

import java.util.List;
import java.util.Optional;

public interface IcomposantService {
    List<Composant> getAllComposants();
    Optional<Composant> getComposantById(int id);
    Composant saveComposant(Composant composant);
    void deleteComposantById(int id);
}
