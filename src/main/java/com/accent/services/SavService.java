package com.accent.services;

import com.accent.entities.Sav;
import com.accent.repositories.SavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavService implements IsavService{
    @Autowired
    private SavRepository savRepository;

    @Override
    public List<Sav> getAllSavs() {
        return savRepository.findAll();
    }

    @Override
    public Optional<Sav> getSavById(int id) {
        return savRepository.findById(id);
    }

    @Override
    public Sav saveSav(Sav sav) {
        return savRepository.save(sav);
    }

    @Override
    public void deleteSavById(int id) {
        savRepository.deleteById(id);
    }
}
