package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.InstitutionDto;

import java.util.List;

public interface IInstitutionService {

    List<InstitutionDto> findAllSortAscById();

    InstitutionDto findById(Long id);
}
