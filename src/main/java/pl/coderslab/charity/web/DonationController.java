package pl.coderslab.charity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.service.CategoryService;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user/donate")
public class DonationController {

    private final CategoryService categoryService;

    public DonationController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public String formDisplay(Model model) {

        List<CategoryDto> categories = categoryService.findAll();

        log.debug("categories: {}", categories);

        model.addAttribute("categories", categories);


        return "form";
    }

}
