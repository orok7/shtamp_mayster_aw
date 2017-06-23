package eins.service.impl;

import eins.dao.ProductToBuyDAO;
import eins.entity.ProductToBuy;
import eins.service.interfaces.ProductToBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ProductToBuyServiceImpl implements ProductToBuyService {

    @Autowired
    ProductToBuyDAO dbDAO;

    @Override
    public void save(ProductToBuy o) {
        dbDAO.save(o);
    }

    @Override
    public ProductToBuy findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<ProductToBuy> findAll() {
        return dbDAO.findAll();
    }
}