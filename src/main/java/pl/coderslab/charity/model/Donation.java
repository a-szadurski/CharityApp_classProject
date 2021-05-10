package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.charity.dto.DonationDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    public Donation(DonationDto donationDto, List<Category> categories, Institution institution, User user) {
        this.id = donationDto.getId();
        this.quantity = donationDto.getQuantity();
        this.street = donationDto.getStreet();
        this.city = donationDto.getCity();
        this.zipCode = donationDto.getZipCode();
        this.pickupDate = donationDto.getPickupDate();
        this.pickupTime = donationDto.getPickupTime();
        this.pickupComment = donationDto.getPickupComment();
        this.phoneNumber = donationDto.getPhoneNumber();
        this.pickupStatus = donationDto.isPickupStatus();
        this.entryDate = donationDto.getEntryDate();
        this.pickupStatusDate = donationDto.getPickupStatusDate();
        this.categories = categories;
        this.institution = institution;
        this.user = user;
    }


}
