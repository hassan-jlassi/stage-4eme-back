package com.accent.controllers;

import com.accent.entities.Vente;
import com.accent.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @GetMapping("/")
    public List<Vente> getAllVentes() {
        return venteService.getAllVentes();
    }

    @GetMapping("/{id}")
    public Optional<Vente> getVenteById(@PathVariable("id") int id) {
        return venteService.getVenteById(id);
    }

    @PostMapping("/")
    public Vente saveVente(@RequestBody Vente vente) {
        return venteService.saveVente(vente);
    }

    @PutMapping("/{id}")
    public Vente updateVente(@PathVariable("id") int id, @RequestBody Vente updatedVente) {
        Optional<Vente> existingVente = venteService.getVenteById(id);

        if (existingVente.isPresent()) {
            Vente venteToUpdate = existingVente.get();
            venteToUpdate.setDateVente(updatedVente.getDateVente());
            venteToUpdate.setMontantTotal(updatedVente.getMontantTotal());
            venteToUpdate.setProduit(updatedVente.getProduit());
            venteToUpdate.setClient(updatedVente.getClient());

            return venteService.saveVente(venteToUpdate);
        } else {
            throw new RuntimeException("Vente not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteVenteById(@PathVariable("id") int id) {
        venteService.deleteVenteById(id);
    }
}
