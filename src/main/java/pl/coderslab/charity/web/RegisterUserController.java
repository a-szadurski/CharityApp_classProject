package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

    private final UserService userService;

    public RegisterUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayForm(Model model) {

        model.addAttribute("user", new UserDto());

        return "register";
    }

    @PostMapping
    public String registerUser(Model model, @Valid @ModelAttribute("user") UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("user", new UserDto());
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/login";
    }


// --creating test users--

//    @GetMapping("/create-user")
//    @ResponseBody
//    public String createUser() {
//        User user = new User();
//        user.setEmail("admin");
//        user.setPassword("adminCatShow");
//        userService.saveUser(user);
//
//        User user2 = new User();
//        user2.setEmail("user");
//        user2.setPassword("userCatShow");
//        userService.saveUser(user2);
//
//        return "admin, user";
//    }
}