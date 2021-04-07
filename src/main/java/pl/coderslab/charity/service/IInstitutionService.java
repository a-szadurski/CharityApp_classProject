package pl.coderslab.charity.service;

import org.springframework.data.domain.Sort;
import pl.coderslab.charity.model.Institution;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IInstitutionService {

    List<Institution> findAll(Sort sort);
}
