package pl.coderslab.charity.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/*
id
quantity (liczba worków) (Integer)
categories (lista obiektów typu Category), pamiętaj o odpowiedniej adnotacji
institution (obiekt typu Institution), pamiętaj o odpowiedniej adnotacji.
street (String)
city (String)
zipCode (String)
pickUpDate (LocalDate)
pickUpTime (LocalTime)
pickUpComment (String)
 */

@Entity
@Data
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

    @OneToMany
    private List<Category> categories;

    @OneToOne
    private Institution institution;


}
