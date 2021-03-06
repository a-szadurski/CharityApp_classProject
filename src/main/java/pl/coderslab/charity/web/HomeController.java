package pl.coderslab.charity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(InstitutionServiceImpl institutionService, DonationServiceImpl donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping
    public String homeAction(Model model) {

        List<InstitutionDto> institutionList = institutionService.findAllSortAscById();
        Integer quantityTotal = donationService.quantityTotal();
        Integer donationSum = donationService.donationsDeliveredCount();

        if (quantityTotal == null) {
            quantityTotal = 0;
        }

        model.addAttribute("institutions", institutionList);
        model.addAttribute("quantityTotal", quantityTotal);
        model.addAttribute("donationSum", donationSum);

        logger.debug("institutionList: {}", institutionList);
        logger.debug("quantityTotal: {}", quantityTotal);
        logger.debug("donationSum: {}", donationSum);

        return "index";
    }
}
