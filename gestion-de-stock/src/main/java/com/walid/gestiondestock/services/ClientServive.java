package com.walid.gestiondestock.services;

import com.walid.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientServive {

    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    Void delete(Integer id);
}
