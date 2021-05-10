package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionDto;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequestMapping("/admin/institution")
@Slf4j
public class AdminInstitutionsCrudController {

    private final InstitutionService institutionService;
    private final String INSTITUTIONS_LIST = "redirect:/admin/institution/all";

    public AdminInstitutionsCrudController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String redirectToList() {
        return INSTITUTIONS_LIST;
    }

    @GetMapping("/all")
    public String displayInstitutionList(Model model) {

        model.addAttribute("institutions", institutionService.findAllSortAscById());
        return "admin/institution-list";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("institution", new InstitutionDto());
        return "admin/institution-add";
    }

    @PostMapping("/add")
    public String executeAddForm(@ModelAttribute("institution") InstitutionDto institutionDto) {
        institutionService.saveDtoToEntity(institutionDto);
        return INSTITUTIONS_LIST;
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(Model model, @PathVariable Long id) {

        InstitutionDto institutionDto = institutionService.findById(id);
        log.debug("{} institution by id: {}", this.getClass(), institutionDto);
        model.addAttribute("institution", institutionDto);
        return "admin/institution-update";
    }

    @PostMapping("/update/{id}")
    public String executeUpdateForm(@ModelAttribute("institution") InstitutionDto institutionDto) {
        institutionService.saveDtoToEntity(institutionDto);
        return INSTITUTIONS_LIST;
    }

    @GetMapping("/delete/{id}")
    public String displayDeleteForm(Model model, @PathVariable Long id) {

        InstitutionDto institutionDto = institutionService.findById(id);
        log.debug("{} institution by id: {}", this.getClass(), institutionDto);
        model.addAttribute("institution", institutionDto);
        return "admin/institution-delete";
    }

    @PostMapping("/delete/{id}")
    public String executeDeleteForm(@ModelAttribute("institution") InstitutionDto institutionDto) {

        institutionService.deleteById(institutionDto.getId());
        return INSTITUTIONS_LIST;
    }
}

