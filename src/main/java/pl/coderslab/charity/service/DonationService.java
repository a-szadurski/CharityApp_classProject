package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.User;

import java.time.LocalDate;
import java.util.List;

public interface DonationService {

    Integer quantityTotal();

    Integer donationsDeliveredCount();

    void saveDonation(DonationDto donationDto, User user);

    List<DonationDto> findAllByUserPickupStatusAscPickupDateDescEntryDateDesc(Long id);

    DonationDto findByIdAndUser(Long donationId, Long userId);

    void updateStatus(LocalDate date, Long id);
}
