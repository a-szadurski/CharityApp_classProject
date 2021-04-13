package pl.coderslab.charity.service;

import org.springframework.data.domain.Sort;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    void saveUser(UserDto userDto);

    List<User> findAll(Sort sort);
}