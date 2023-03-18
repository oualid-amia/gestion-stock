package com.walid.gestiondestock.services;

import com.walid.gestiondestock.dto.ClientDto;
import com.walid.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    Void delete(Integer id);
}
