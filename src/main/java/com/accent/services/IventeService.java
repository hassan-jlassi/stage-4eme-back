package com.accent.services;

import com.accent.entities.Vente;
import java.util.List;
import java.util.Optional;

public interface IventeService {
    List<Vente> getAllVentes();
    Optional<Vente> getVenteById(int id);
    Vente saveVente(Vente vente);
    void deleteVenteById(int id);
}
