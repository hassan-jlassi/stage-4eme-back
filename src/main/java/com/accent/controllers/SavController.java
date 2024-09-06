package com.accent.controllers;

import com.accent.entities.Sav;
import com.accent.services.SavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/savs")
public class SavController {

    @Autowired
    private SavService savService;

    @GetMapping("/")
    public List<Sav> getAllSavs() {
        return savService.getAllSavs();
    }

    @GetMapping("/{id}")
    public Optional<Sav> getSavById(@PathVariable("id") int id) {
        return savService.getSavById(id);
    }

    @PostMapping("/")
    public Sav saveSav(@RequestBody Sav sav) {
        return savService.saveSav(sav);
    }

    @PutMapping("/{id}")
    public Sav updateSav(@PathVariable("id") int id, @RequestBody Sav updatedSav) {
        Optional<Sav> existingSav = savService.getSavById(id);

        if (existingSav.isPresent()) {
            Sav savToUpdate = existingSav.get();
            savToUpdate.setNumSerie(updatedSav.getNumSerie());
            savToUpdate.setIMEI(updatedSav.getIMEI());
            savToUpdate.setDateReception(updatedSav.getDateReception());
            savToUpdate.setCategorie(updatedSav.getCategorie());

            return savService.saveSav(savToUpdate);
        } else {
            throw new RuntimeException("Sav not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSavById(@PathVariable("id") int id) {
        savService.deleteSavById(id);
    }
}
