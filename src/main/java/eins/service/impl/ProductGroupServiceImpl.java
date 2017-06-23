package eins.service.impl;

import eins.dao.ProductGroupDAO;
import eins.entity.ProductGroup;
import eins.service.interfaces.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ProductGroupServiceImpl implements ProductGroupService {

    @Autowired
    ProductGroupDAO dbDAO;

    @Override
    public void save(ProductGroup o) {
        dbDAO.save(o);
    }

    @Override
    public ProductGroup findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<ProductGroup> findAll() {
        return dbDAO.findAll();
    }
}