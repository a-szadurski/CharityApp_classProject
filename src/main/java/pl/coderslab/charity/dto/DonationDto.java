package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.charity.model.Donation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {

    private Long id;

    private Integer quantity;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickupDate;
    private LocalTime pickupTime;
    private String pickupComment;
    private String phoneNumber;
    private boolean pickupStatus;
    private LocalDate entryDate;
    private LocalDate pickupStatusDate;

    private List<CategoryDto> categories;

    private InstitutionDto institution;

    public DonationDto(Donation donation) {
        this.id = donation.getId();
        this.quantity = donation.getQuantity();
        this.street = donation.getStreet();
        this.city = donation.getCity();
        this.zipCode = donation.getZipCode();
        this.pickupDate = donation.getPickupDate();
        this.pickupTime = donation.getPickupTime();
        this.pickupComment = donation.getPickupComment();
        this.phoneNumber = donation.getPhoneNumber();
        this.pickupStatus = donation.isPickupStatus();
        this.entryDate = donation.getEntryDate();
        this.pickupStatusDate = donation.getPickupStatusDate();
        this.categories = donation.getCategories().stream().map(CategoryDto::new).collect(Collectors.toList());
        this.institution = new InstitutionDto(donation.getInstitution());
    }
}
