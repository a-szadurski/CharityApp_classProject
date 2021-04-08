package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class CategoryDto {

    private Long id;

    private Integer quantity;
    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickupDate;
    private LocalTime pickupTime;
    private String pickupComment;

    private List<Category> categories;

    private Institution institution;

}
