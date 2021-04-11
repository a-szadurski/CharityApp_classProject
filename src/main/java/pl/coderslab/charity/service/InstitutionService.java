package pl.coderslab.charity.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionService implements IInstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<InstitutionDto> findAllSortAscById() {
        return institutionRepository
                .findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(institution -> new InstitutionDto(institution.getId(), institution.getName(), institution.getDescription()))
                .collect(Collectors.toList());
    }
}
