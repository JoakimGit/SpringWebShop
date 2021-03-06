package dk.kea.products_mvc.springmvc.Repository;

import dk.kea.products_mvc.springmvc.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
