package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.DonationDto;

public interface IDonationService {

    Integer quantityTotal();

    Integer donationsDeliveredCount();

    void saveDonation(DonationDto donationDto);
}
