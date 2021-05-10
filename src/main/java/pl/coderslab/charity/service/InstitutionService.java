package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.InstitutionDto;

import java.util.List;

public interface InstitutionService {

    List<InstitutionDto> findAllSortAscById();

    InstitutionDto findById(Long id);

    void deleteById(Long id);

    void saveDtoToEntity(InstitutionDto institutionDto);

}
