package pl.coderslab.charity.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    public Donation(Integer quantity,
                    String street,
                    String city,
                    String zipCode,
                    LocalDate pickupDate,
                    LocalTime pickupTime,
                    String pickupComment,
                    String phoneNumber,
                    List<Category> categories,
                    Institution institution) {
        this.quantity = quantity;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.pickupComment = pickupComment;
        this.phoneNumber = phoneNumber;
        this.categories = categories;
        this.institution = institution;
    }


}
