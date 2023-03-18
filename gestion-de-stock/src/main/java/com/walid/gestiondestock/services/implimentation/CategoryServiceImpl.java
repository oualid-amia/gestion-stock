package com.walid.gestiondestock.services.implimentation;

import com.walid.gestiondestock.dto.CategoryDto;
import com.walid.gestiondestock.exception.EntityNotFoundException;
import com.walid.gestiondestock.exception.ErrorCodes;
import com.walid.gestiondestock.exception.InvalidEntityException;
import com.walid.gestiondestock.model.Category;
import com.walid.gestiondestock.repository.CategoryRepository;
import com.walid.gestiondestock.services.CategoryService;
import com.walid.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }




    @Override
    public CategoryDto save(CategoryDto dto) {

        List<String > errors = CategoryValidator.Validate(dto);
        if(!errors.isEmpty()){

            log.error("Category is not valide {}", dto);
            throw new InvalidEntityException("La catégorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALIDE, errors);
        }

        return CategoryDto.fromEntity(
                categoryRepository.save(
                        CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {

        if (id == null){

            log.error("Category ID is null");
        }

        Optional<Category> category = categoryRepository.findById(id);


        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun Category avec l'ID = " + id + " n'est trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {

        if(!StringUtils.hasLength(codeCategory)){

            log.error("codeCategory est null");
            return null;

        }



//        Optional<Category> category = categoryRepository.findCategoryByCodeCategory(codeCategory);
//
//        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
//                new EntityNotFoundException(
//                        "Aucun Category avec le code = " + codeCategory + " n'est trouve dans la BDD",
//                        ErrorCodes.CATEGORY_NOT_FOUND)

        return categoryRepository.findCategoryByCodeCategory(codeCategory)
                .map(CategoryDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun Category avec le code = " + codeCategory + " n'est trouve dans la BDD",
                       ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {

            log.error("Category ID is Null");
        }
        categoryRepository.deleteById(id);

    }
}
