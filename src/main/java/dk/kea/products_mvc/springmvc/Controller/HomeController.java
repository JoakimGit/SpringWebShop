package dk.kea.products_mvc.springmvc.Controller;

import dk.kea.products_mvc.springmvc.Model.Product;
import dk.kea.products_mvc.springmvc.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("prod", productService.readAll());
        return("/index");
    }

    @GetMapping("/create")
    public String create() {
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product prod) {
        productService.create(prod);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("prod", productService.read(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product prod) {
        productService.update(prod);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        /* if (animalService.delete(id))
            model.addAttribute("status", "element " + id + " slettet";
            else
            model.addAttribute("status", "element " + id + " kunne ikke slettes!";
         */
        productService.delete(id);
        return "redirect:/";
    }

}
