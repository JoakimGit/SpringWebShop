package dk.kea.products_mvc.springmvc.Service;

import dk.kea.products_mvc.springmvc.Model.Category;
import dk.kea.products_mvc.springmvc.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findById(long id) {
        Optional<Category> optionalCompany = categoryRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException("Company not found");
        }
        return optionalCompany.get();
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
