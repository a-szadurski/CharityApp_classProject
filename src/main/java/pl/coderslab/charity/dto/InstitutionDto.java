package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstitutionDto {

    private Long id;

    private String name;

    private String description;
}
