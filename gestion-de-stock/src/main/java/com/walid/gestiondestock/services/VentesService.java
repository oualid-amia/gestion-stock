package com.walid.gestiondestock.services;


import com.walid.gestiondestock.dto.CommandeClientDto;
import com.walid.gestiondestock.dto.VentesDto;

import java.util.List;

public interface VentesService {

    VentesDto save(VentesDto dto);

    VentesDto findById(Integer id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void delete(Integer id);
}
