package com.walid.gestiondestock.repository;

import com.walid.gestiondestock.model.CommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandFournisseur, Integer> {

    Optional<CommandFournisseur> findCommandeFournisseurByCode(String code);
}
