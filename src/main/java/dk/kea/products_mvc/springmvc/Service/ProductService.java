package dk.kea.products_mvc.springmvc.Service;

import dk.kea.products_mvc.springmvc.Model.Product;
import dk.kea.products_mvc.springmvc.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> readAll() {
        return productRepository.readAll();
    }

    public Product read(long id) {
        return productRepository.read(id);
    }

    public void create(Product product) {
        productRepository.create(product);
    }

    public boolean update(Product product) {
        return productRepository.update(product);
    }

    public boolean delete(long id) {
        return productRepository.delete(id);
    }


}
