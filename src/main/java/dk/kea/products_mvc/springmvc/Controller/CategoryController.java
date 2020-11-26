package dk.kea.products_mvc.springmvc.Controller;

import dk.kea.products_mvc.springmvc.Model.Category;
import dk.kea.products_mvc.springmvc.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String categoryView(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/category/overview";
    }

    @GetMapping("/category/details/{id}")
    public String details(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/details";
    }

    @GetMapping("/category/create")
    public String create() {
        return "/category/create";
    }

    @PostMapping("/category/create")
    public String create(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/category/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/update";
    }

    @PostMapping("/category/update")
    public String update(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        categoryService.deleteById(id);
        return "redirect:/category";
    }

}
