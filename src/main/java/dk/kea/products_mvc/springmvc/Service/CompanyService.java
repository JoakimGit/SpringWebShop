package dk.kea.products_mvc.springmvc.Service;

import dk.kea.products_mvc.springmvc.Model.Company;
import dk.kea.products_mvc.springmvc.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> findAll() {
        return (List<Company>) companyRepository.findAll();
    }

    public List<Company> findAllOrderByName() {
        return companyRepository.findAllByOrderByName();
    }

    public Company findById(long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException("Company not found");
        }
        return optionalCompany.get();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void deleteById(long id) {
        companyRepository.deleteById(id);
    }
}
