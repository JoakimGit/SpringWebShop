package dk.kea.products_mvc.springmvc.Repository;

import dk.kea.products_mvc.springmvc.Model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findAllByOrderByName();

}
