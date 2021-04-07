package pl.coderslab.charity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionService institutionService;
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String homeAction(Model model) {

        List<Institution> institutionList = institutionService.findAllSortAscById();

        model.addAttribute("institutions", institutionList);
        logger.debug("display institutions debug: {}", institutionList);

        return "index";
    }
}
