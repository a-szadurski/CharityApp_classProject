package pl.coderslab.charity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.service.CategoryServiceImpl;

@Component
public class CategoryDtoConverter implements Converter<String, CategoryDto> {

    private final CategoryServiceImpl categoryService;

    public CategoryDtoConverter(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto convert(String id) {
        return categoryService.findById(Long.parseLong(id));
    }
}
