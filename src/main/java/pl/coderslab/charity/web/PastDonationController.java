package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.UserService;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/user/donation")
public class PastDonationController {

    private final String REDIRECT_LIST = "redirect:/user/donation/list";
    private final DonationService donationService;
    private final UserService userService;

    public PastDonationController(DonationService donationService, UserService userService) {
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping
    public String redirectToList() {
        return REDIRECT_LIST;
    }

    @GetMapping("/list")
    public String displayList(Model model, Principal principal) {

        User user = userService.findByEmail(principal.getName());

        model.addAttribute("donations", donationService.findAllByUserPickupStatusAscPickupDateDescEntryDateDesc(user.getId()));
        return "user/donation-list";
    }

    @GetMapping("/{id}")
    public String displayDetailsForm(Model model, Principal principal, @PathVariable Long id) {

        User user = userService.findByEmail(principal.getName());
        model.addAttribute("d", donationService.findByIdAndUser(id, user.getId()));
        return "user/donation-details";
    }

    @PostMapping("/{id}")
    public String executeDetailsForm(@ModelAttribute("d") DonationDto donationDto, @PathVariable Long id) {

        donationService.updateStatus(donationDto.getPickupStatusDate(), id);
        return REDIRECT_LIST;
    }
}
