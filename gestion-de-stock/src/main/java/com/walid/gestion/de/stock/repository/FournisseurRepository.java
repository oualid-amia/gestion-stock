package com.walid.gestion.de.stock.repository;

import com.walid.gestion.de.stock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur , Integer> {
}
