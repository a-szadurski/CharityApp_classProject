package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final InstitutionService institutionService;

    public AdminPanelController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String displayAdminPanelHome(Model model) {

        model.addAttribute("institutions", institutionService.findAllSortAscById());

        return "admin-home";
    }
}
