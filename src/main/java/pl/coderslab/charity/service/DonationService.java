package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.DonationDto;

public interface DonationService {

    Integer quantityTotal();

    Integer donationsDeliveredCount();

    void saveDonation(DonationDto donationDto);
}
