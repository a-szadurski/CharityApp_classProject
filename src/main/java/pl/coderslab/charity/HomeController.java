package pl.coderslab.charity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    Logger logger = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping("/")
    public String homeAction(Model model){

        model.addAttribute("institutions", institutionService.findAll(Sort.by(Sort.Direction.ASC, "id")));
        logger.debug(institutionService.findAll(Sort.by(Sort.Direction.ASC, "id")).toString());

        return "index";
    }
}
