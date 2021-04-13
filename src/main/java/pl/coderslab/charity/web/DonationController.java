package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user/donate")
public class DonationController {

    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;

    public DonationController(CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService, DonationServiceImpl donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
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

        return "form";
    }

    @PostMapping
    public String formSubmit(@ModelAttribute("donation") DonationDto donation, BindingResult result) {

        log.debug("donationDtoSaveDebug: {}", donation);

        donationService.saveDonation(donation);

        return "redirect:/user/donate/confirm";
    }

    @GetMapping("/confirm")
    public String formConfirm() {
        return "form-confirmation";
    }

}
