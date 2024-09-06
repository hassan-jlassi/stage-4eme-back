package com.accent.services;

import com.accent.entities.Composant;
import com.accent.repositories.ComposantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComposantService implements IcomposantService {
    @Autowired
    private ComposantRepository composantRepository;

    @Override
    public List<Composant> getAllComposants() {
        return composantRepository.findAll();
    }

    @Override
    public Optional<Composant> getComposantById(int id) {
        return composantRepository.findById(id);
    }

    @Override
    public Composant saveComposant(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public void deleteComposantById(int id) {
        composantRepository.deleteById(id);
    }
}
