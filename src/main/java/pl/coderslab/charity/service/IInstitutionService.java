package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface IInstitutionService {

    List<InstitutionDto> findAllSortAscById();
}
