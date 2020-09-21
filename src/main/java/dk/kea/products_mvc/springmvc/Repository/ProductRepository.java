package dk.kea.products_mvc.springmvc.Repository;

import dk.kea.products_mvc.springmvc.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        this.products.add(new Product(1, "Kaffe", 50, "Arabica"));
        this.products.add(new Product(2, "Te", 35, "Earl Grey"));
        this.products.add(new Product(3, "Lakridspipe", 8.50, "Skippers lakridspipe"));
        this.products.add(new Product(4, "Matador mix", 20, "Haribo matador mix"));
    }

    @Override
    public List<Product> readAll() {
        return this.products;
    }

    @Override
    public Product read(long id) {
        int i = 0;
        while (i < products.size()) {
            if (products.get(i).getId() == id) return products.get(i);
            i++;
        }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public boolean update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        int i = 0;
        while (i < products.size()) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
}
