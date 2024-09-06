package com.accent.repositories;

import com.accent.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposantRepository extends JpaRepository<Composant, Integer> {
}
