package pl.coderslab.charity.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService implements IInstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAllSortAscById() {
        return institutionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
