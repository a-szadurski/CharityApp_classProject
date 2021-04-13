package pl.coderslab.charity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.InstitutionServiceImpl;

@Component
public class InstitutionDtoConverter implements Converter<String, InstitutionDto> {

    private final InstitutionServiceImpl institutionService;

    public InstitutionDtoConverter(InstitutionServiceImpl institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public InstitutionDto convert(String id) {
        return institutionService.findById(Long.parseLong(id));
    }
}