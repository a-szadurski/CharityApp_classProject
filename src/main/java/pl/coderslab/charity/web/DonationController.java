package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.UserService;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user/donate")
public class DonationController {

    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;
    private final UserService userService;

    public DonationController(CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService, DonationServiceImpl donationService, UserService userService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }


    @GetMapping
    public String formDisplay(Model model) {

        List<CategoryDto> categories = categoryService.findAll();
        List<InstitutionDto> institutions = institutionService.findAllSortAscById();

        log.debug("categoriesDebug: {}", categories);
        log.debug("institutionsDebug: {}", institutions);

        model.addAttribute("categories", categories);
        model.addAttribute("donation", new DonationDto());
        model.addAttribute("institutions", institutions);

        return "user/form";
    }

    @PostMapping
    public String formSubmit(@ModelAttribute("donation") DonationDto donation, Principal principal) {

        log.debug("donationDtoSaveDebug: {}", donation);

        User user = userService.findByEmail(principal.getName());

        donationService.saveDonation(donation, user);

        return "redirect:/user/donate/confirm";
    }

    @GetMapping("/confirm")
    public String formConfirm() {
        return "user/form-confirmation";
    }

}
