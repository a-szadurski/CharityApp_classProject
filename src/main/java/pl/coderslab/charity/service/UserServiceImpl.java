package pl.coderslab.charity.service;

import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.exception.UserAlreadyExistException;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {

        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
        }
        final User user = new User();
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);
        user.setEmail(userDto.getEmail());
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public List<UserDto> findAllUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        return userRepository.findAllByRolesIn(roles).stream()
                .map(user -> new UserDto(
                        user.getId(), user.getEmail(), user.isEnabled()
                )).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllSuperUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        return userRepository.findAllByRolesIn(roles).stream()
                .map(user -> new UserDto(
                        user.getId(), user.getEmail(), user.isEnabled()
                )).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserDto userDto) {

        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
        }

        User user;

        Optional<User> userOptional = userRepository.findById(userDto.getId());

        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new NotFoundException("User not found");
        }

        if (userDto.getEmail() != null && !userDto.getEmail().equals("")) {
            user.setEmail(userDto.getEmail());
        }

        if (userDto.getPassword() != null && !userDto.getPassword().equals("")) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        userRepository.save(user);
    }

    @Override
    public UserDto findById(Long id) {

        UserDto userDto;

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userDto = new UserDto(userOptional.get().getId(), userOptional.get().getEmail(), userOptional.get().isEnabled());
        } else {
            throw new NotFoundException("User not found");
        }

        return userDto;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
