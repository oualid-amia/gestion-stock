package com.walid.gestiondestock.services;

import com.walid.gestiondestock.dto.ArticleDto;
import com.walid.gestiondestock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void  delete(Integer id);
}
