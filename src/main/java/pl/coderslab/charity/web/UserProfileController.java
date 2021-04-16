package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user/profile")
@Slf4j
public class UserProfileController {

    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayUpdateForm(Model model, Principal principal) {

        UserDto userDto = new UserDto(userService.findByEmail(principal.getName()));
        log.debug("{} user by principalName: {}", this.getClass(), userDto);
        userDto.setPassword(null);
        model.addAttribute("user", userDto);
        return "user/user-profile";
    }

    @PostMapping
    public String executeUpdateForm(@ModelAttribute("user") UserDto userDto, Principal principal) {
        userService.updateUser(userDto, principal);
        return "redirect:/user/profile";
    }
}
