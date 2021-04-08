package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService implements IDonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Integer quantityTotal() {
        return donationRepository.quantityTotal();
    }

    @Override
    public Integer donationSum() {
        return donationRepository.countAllByPickupDateIsNotNullAndPickupTimeIsNotNullAndPickupCommentIsNotNull();
    }
}
