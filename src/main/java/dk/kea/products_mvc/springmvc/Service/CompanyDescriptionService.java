package dk.kea.products_mvc.springmvc.Service;

import dk.kea.products_mvc.springmvc.Model.CompanyDescription;
import dk.kea.products_mvc.springmvc.Repository.CompanyDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyDescriptionService {

    @Autowired
    CompanyDescriptionRepository descriptionRepository;

    public List<CompanyDescription> findAll() {
        return (List<CompanyDescription>) descriptionRepository.findAll();
    }

    public CompanyDescription findById(long id) {
        Optional<CompanyDescription> optionalCompanyDescription = descriptionRepository.findById(id);
        if (optionalCompanyDescription.isEmpty()) {
            throw new RuntimeException("Company description was not found");
        }
        return optionalCompanyDescription.get();
    }

    public void create(CompanyDescription companyDescription) {
        descriptionRepository.save(companyDescription);
    }

    public void update(CompanyDescription companyDescription) {
        descriptionRepository.save(companyDescription);
    }

    public void deleteById(long id) {
        descriptionRepository.deleteById(id);
    }
}
