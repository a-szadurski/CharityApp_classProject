package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

}
