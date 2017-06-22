package eins.service.interfaces;

import eins.entity.Product;

import java.util.List;

public interface ProductService {

    void save(Product o);

    Product findOne(int id);

    List<Product> findAll();

}
