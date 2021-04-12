package pl.coderslab.charity.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.InstitutionDto;

@Component
public class InstitutionDtoConverter implements Converter<String, InstitutionDto> {

    private final InstitutionService institutionService;

    public InstitutionDtoConverter(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public InstitutionDto convert(String id) {
        return institutionService.findById(Long.parseLong(id));
    }
}