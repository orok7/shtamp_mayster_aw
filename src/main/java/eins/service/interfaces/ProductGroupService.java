package eins.service.interfaces;

import eins.entity.ProductGroup;

import java.util.List;

public interface ProductGroupService {

    void save(ProductGroup o);

    ProductGroup findOne(int id);

    List<ProductGroup> findAll();

}
