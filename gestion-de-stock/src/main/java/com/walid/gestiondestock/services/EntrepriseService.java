package com.walid.gestiondestock.services;

import com.walid.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {


    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    Void delete(Integer id);
}
