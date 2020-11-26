package dk.kea.products_mvc.springmvc.Controller;

import dk.kea.products_mvc.springmvc.Model.Category;
import dk.kea.products_mvc.springmvc.Model.Company;
import dk.kea.products_mvc.springmvc.Model.Product;
import dk.kea.products_mvc.springmvc.Service.CategoryService;
import dk.kea.products_mvc.springmvc.Service.CompanyDescriptionService;
import dk.kea.products_mvc.springmvc.Service.CompanyService;
import dk.kea.products_mvc.springmvc.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyDescriptionService descriptionService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/product")
    public String productView(Model model) {
        model.addAttribute("products", productService.findAll());
        return("/product/overview");
    }

    @GetMapping("/product/details/{id}")
    public String details(@PathVariable("id") long id, Model model) {
        Product product = productService.findById(id);
        long company_id = product.getCompany().getCompany_id();
        model.addAttribute("product", product);
        model.addAttribute("company_description", descriptionService.findById(company_id));
        return "/product/details";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("companies", companyService.findAllOrderByName());
        model.addAttribute("categories", categoryService.findAll());
        return "/product/create";
    }

    @PostMapping("/product/create")
    public String create(@ModelAttribute Product prod, @RequestParam("company_name") long company_id, @RequestParam(required = false) Set<String> chosen_categories) {
        Company productCompany = companyService.findById(company_id);
        prod.setCompany(productCompany);
        if (chosen_categories != null) {
            for (String category : chosen_categories) {
                Category cat = categoryService.findByName(category);
                prod.addCategory(cat);
            }
        }
        productService.save(prod);
        return "redirect:/product";
    }

    @GetMapping("/product/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("companies", companyService.findAllOrderByName());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("chosen_categories", product.getCategories());
        return "/product/update";
    }

    @PostMapping("/product/update")
    public String update(@ModelAttribute Product prod, @RequestParam("company_name") long company_id, @RequestParam(required = false) Set<String> chosen_categories) {
        Company productCompany = companyService.findById(company_id);
        prod.setCompany(productCompany);
        if (chosen_categories != null) {
            for (String category : chosen_categories) {
                Category cat = categoryService.findByName(category);
                prod.addCategory(cat);
            }
        }
        productService.save(prod);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}
