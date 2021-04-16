package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Integer quantityTotal() {
        return donationRepository.quantityTotal();
    }

    @Override
    public Integer donationsDeliveredCount() {
        return donationRepository.donationsDeliveredCount();
    }

    @Override
    public void saveDonation(DonationDto donationDto) {

        List<Category> categories = donationDto.getCategories().stream()
                .map(Category::new)
                .collect(Collectors.toList());

        Institution institution = new Institution(donationDto.getInstitution());

        donationRepository.save(new Donation(donationDto, categories, institution));
    }
}
