package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.DonationRepository;

import java.time.LocalDate;
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
    public void saveDonation(DonationDto donationDto, User user) {

        List<Category> categories = donationDto.getCategories().stream()
                .map(Category::new)
                .collect(Collectors.toList());

        Institution institution = new Institution(donationDto.getInstitution());

        donationRepository.save(new Donation(donationDto, categories, institution, user));
    }

    @Override
    public List<DonationDto> findAllByUserPickupStatusAscPickupDateDescEntryDateDesc(Long id) {
        return donationRepository.findAllByUserPickupStatusAscPickupDateDescEntryDateDesc(id).stream()
                .map(DonationDto::new).collect(Collectors.toList());
    }

    @Override
    public DonationDto findByIdAndUser(Long donationId, Long userId) {
        return new DonationDto(donationRepository.findByIdAndUser(donationId, userId));
    }

    @Override
    public void updateStatus(LocalDate date, Long id) {
        donationRepository.updatePickupStatus(date, id);
    }
}
