package dk.kea.products_mvc.springmvc.Repository;

import dk.kea.products_mvc.springmvc.Model.CompanyDescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDescriptionRepository extends CrudRepository<CompanyDescription, Long> {
}
