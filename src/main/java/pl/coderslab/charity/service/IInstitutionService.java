package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface IInstitutionService {

    List<Institution> findAllSortAscById();
}
