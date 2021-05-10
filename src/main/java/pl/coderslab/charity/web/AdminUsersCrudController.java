package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

@Controller
@RequestMapping("/admin/user")
@Slf4j
public class AdminUsersCrudController {

    private final UserService userService;
    private final String USERS_LIST = "redirect:/admin/user/all";

    public AdminUsersCrudController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String redirectToList() {
        return USERS_LIST;
    }

    @GetMapping("/all")
    public String displayList(Model model) {

        model.addAttribute("users", userService.findAllUsers());
        return "admin/user-list";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "admin/user-add";
    }

    @PostMapping("/add")
    public String executeAddForm(@ModelAttribute("user") UserDto userDto) {
        userService.saveUser(userDto);
        return USERS_LIST;
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(Model model, @PathVariable Long id) {

        UserDto userDto = userService.findById(id);
        log.debug("{} user by id: {}", this.getClass(), userDto);
        userDto.setPassword(null);
        model.addAttribute("user", userDto);
        return "admin/user-update";
    }

    @PostMapping("/update/{id}")
    public String executeUpdateForm(@ModelAttribute("user") UserDto userDto, @PathVariable Long id) {
        userService.updateUser(userDto, new User(userDto));
        return USERS_LIST;
    }

    @GetMapping("/delete/{id}")
    public String displayDeleteForm(Model model, @PathVariable Long id) {

        UserDto userDto = userService.findById(id);
        log.debug("{} user by id: {}", this.getClass(), userDto);
        model.addAttribute("user", userDto);
        return "admin/user-delete";
    }

    @PostMapping("/delete/{id}")
    public String executeDeleteForm(@ModelAttribute("user") UserDto userDto) {

        userService.deleteById(userDto.getId());
        return USERS_LIST;
    }
}

