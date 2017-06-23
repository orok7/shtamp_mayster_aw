package eins.service.impl;

import eins.dao.ProductDAO;
import eins.entity.Product;
import eins.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO dbDAO;

    @Override
    public void save(Product o) {
        dbDAO.save(o);
    }

    @Override
    public Product findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return dbDAO.findAll();
    }
}