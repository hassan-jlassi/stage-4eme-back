package com.accent.services;

import com.accent.entities.Sav;

import java.util.List;
import java.util.Optional;

public interface IsavService {
    List<Sav> getAllSavs();
    Optional<Sav> getSavById(int id);
    Sav saveSav(Sav sav);
    void deleteSavById(int id);
}
