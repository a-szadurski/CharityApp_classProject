package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    User findByEmail(String email);

    void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();

    List<UserDto> findAllSuperUsers();

    void updateUser(UserDto userDto);
    void updateUser(UserDto userDto, Principal principal);

    UserDto findById(Long id);

    void deleteById(Long id);
}