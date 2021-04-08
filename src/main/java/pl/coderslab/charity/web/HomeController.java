package pl.coderslab.charity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping
    public String homeAction(Model model) {

        List<Institution> institutionList = institutionService.findAllSortAscById();
        Integer quantityTotal = donationService.quantityTotal();

        model.addAttribute("institutions", institutionList);
        model.addAttribute("quantityTotal", quantityTotal);
        logger.debug("display institutions debug: {}", institutionList);

        return "index";
    }
}
