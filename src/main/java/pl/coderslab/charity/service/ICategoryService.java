package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> findAll();

}
