package dk.kea.products_mvc.springmvc.Repository;

import java.util.List;

public interface ICrudRepository<T> {
    void create(T t);
    List<T> readAll();
    T read(long id);
    boolean update(T t);
    boolean delete(long id);
}
