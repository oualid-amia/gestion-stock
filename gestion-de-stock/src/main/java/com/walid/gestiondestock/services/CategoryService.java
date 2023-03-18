package com.walid.gestiondestock.services;

import com.walid.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {


    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById (Integer id);

    CategoryDto findByCodeCategory (String code);

    List<CategoryDto> findAll ();

    void delete (Integer id);

}
