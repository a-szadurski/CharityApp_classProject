package pl.coderslab.charity.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.validation.PasswordMatches;
import pl.coderslab.charity.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@PasswordMatches
public class UserDto {

    private Long id;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    @NotNull(message = "{NotEmpty.user.password}")
    @Size(min = 8, max = 25)
    private String password;

    @NotNull(message = "{NotEmpty.user.matchingPassword}")
    @Size(min = 8, max = 25)
    private String matchingPassword;

}
