package com.accent.services;

import com.accent.entities.Vente;
import com.accent.repositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService implements IventeService {
    @Autowired
    private VenteRepository venteRepository;

    @Override
    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }

    @Override
    public Optional<Vente> getVenteById(int id) {
        return venteRepository.findById(id);
    }

    @Override
    public Vente saveVente(Vente vente) {
        return venteRepository.save(vente);
    }

    @Override
    public void deleteVenteById(int id) {
        venteRepository.deleteById(id);
    }
}
