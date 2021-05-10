package pl.coderslab.charity.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<InstitutionDto> findAllSortAscById() {
        return institutionRepository
                .findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(InstitutionDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public InstitutionDto findById(Long id) {
        Institution institution = institutionRepository.findInstitutionById(id);
        return new InstitutionDto(institution);
    }

    @Override
    public void deleteById(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public void saveDtoToEntity(InstitutionDto institutionDto) {
        institutionRepository.save(new Institution(institutionDto));
    }
}
