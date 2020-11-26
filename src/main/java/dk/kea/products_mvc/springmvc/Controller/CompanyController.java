package dk.kea.products_mvc.springmvc.Controller;

import dk.kea.products_mvc.springmvc.Model.Company;
import dk.kea.products_mvc.springmvc.Model.CompanyDescription;
import dk.kea.products_mvc.springmvc.Service.CompanyDescriptionService;
import dk.kea.products_mvc.springmvc.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyDescriptionService descriptionService;

    @GetMapping("/company")
    public String companyView(Model model) {
        model.addAttribute("descriptions", descriptionService.findAll());
        return "/company/overview";
    }

    @GetMapping("/company/details/{id}")
    public String details(@PathVariable("id") long id, Model model) {
        model.addAttribute("company_description", descriptionService.findById(id));
        return "/company/details";
    }

    @GetMapping("/company/create")
    public String create() {
        return "/company/create";
    }

    @PostMapping("/company/create")
    public String create(@ModelAttribute Company company, @ModelAttribute CompanyDescription description) {
        description.setCompany(company);
        descriptionService.create(description);
        return "redirect:/company";
    }

    @GetMapping("/company/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("description", descriptionService.findById(id));
        return "/company/update";
    }

    @PostMapping("/company/update")
    public String update(@ModelAttribute Company company, @ModelAttribute CompanyDescription description) {
        company.setCompany_id(description.getCompanyDesc_id());
        description.setCompany(company);
        descriptionService.create(description);
        return "redirect:/company";
    }

    @GetMapping("/company/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        companyService.deleteById(id);
        return "redirect:/company";
    }
}
