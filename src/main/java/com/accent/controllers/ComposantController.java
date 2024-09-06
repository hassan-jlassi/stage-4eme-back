package com.accent.controllers;

import com.accent.entities.Composant;
import com.accent.services.ComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/composants")
public class ComposantController {

    @Autowired
    private ComposantService composantService;

    @GetMapping("/")
    public List<Composant> getAllComposants() {
        return composantService.getAllComposants();
    }

    @GetMapping("/{id}")
    public Optional<Composant> getComposantById(@PathVariable("id") int id) {
        return composantService.getComposantById(id);
    }

    @PostMapping("/")
    public Composant saveComposant(@RequestBody Composant composant) {
        return composantService.saveComposant(composant);
    }

    @PutMapping("/{id}")
    public Composant updateComposant(@PathVariable("id") int id, @RequestBody Composant updatedComposant) {
        Optional<Composant> existingComposant = composantService.getComposantById(id);

        if (existingComposant.isPresent()) {
            Composant composantToUpdate = existingComposant.get();
            composantToUpdate.setNomC(updatedComposant.getNomC());
            composantToUpdate.setQuantite(updatedComposant.getQuantite());

            return composantService.saveComposant(composantToUpdate);
        } else {
            throw new RuntimeException("Composant not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteComposantById(@PathVariable("id") int id) {
        composantService.deleteComposantById(id);
    }
}
