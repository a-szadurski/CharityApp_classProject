package pl.coderslab.charity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.charity.model.Institution;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDto {

    private Long id;

    private String name;

    private String description;

    public InstitutionDto(Institution institution) {
        this.id = institution.getId();
        this.name = institution.getName();
        this.description = institution.getDescription();
    }
}
