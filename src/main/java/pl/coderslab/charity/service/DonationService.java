package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.User;

public interface DonationService {

    Integer quantityTotal();

    Integer donationsDeliveredCount();

    void saveDonation(DonationDto donationDto, User user);
}
