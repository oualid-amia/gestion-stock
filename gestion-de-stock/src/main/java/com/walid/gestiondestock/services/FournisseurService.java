package com.walid.gestiondestock.services;

import com.walid.gestiondestock.dto.ClientDto;
import com.walid.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    Void delete(Integer id);
}
