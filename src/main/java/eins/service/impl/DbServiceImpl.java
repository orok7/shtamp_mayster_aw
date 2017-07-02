package eins.service.impl;

import eins.dao.*;
import eins.entity.*;
import eins.service.interfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class DbServiceImpl implements DbService {

    @Override
    public void save(Object o, Class<?> clazz) {
        initMyDAOMap();
        dbDAO.get(clazz).save(o);
    }

    @Override
    public Object findOne(int id, Class<?> clazz) {
        initMyDAOMap();
        return dbDAO.get(clazz).findOne(id);
    }

//    @Override
//    public void save(Map<String, String> map, Class<?> clazz) throws Exception {
//        initMyDAOMap();
//        dbDAO.get(clazz).save(map);
//    }

    @Override
    public List<Object> findAll(Class<?> clazz) {
        initMyDAOMap();
        return dbDAO.get(clazz).findAll();
    }



    ////////////////////////////////////////////////////////////////////////


    
    @Autowired private CompanyUserDAO companyUserDAO;
    @Autowired private ImageDAO imageDAO;
    @Autowired private InvoiceDAO invoiceDAO;
    @Autowired private ProductGroupDAO productGroupDAO;
    @Autowired private ProductDAO productDAO;
    @Autowired private ProductToBuyDAO productToBuyDAO;
    @Autowired private RatingDAO ratingDAO;
    @Autowired private ReviewsDAO reviewsDAO;
    @Autowired private UserDAO uDAO;

    private Map<Class<?>, JpaRepository> dbDAO = new HashMap<>();

    private void initMyDAOMap(){
        dbDAO.put(CompanyUser.class, companyUserDAO);
        dbDAO.put(Image.class, imageDAO);
        dbDAO.put(Invoice.class, invoiceDAO);
        dbDAO.put(ProductGroup.class, productGroupDAO);
        dbDAO.put(Product.class, productDAO);
        dbDAO.put(ProductToBuy.class, productToBuyDAO);
        dbDAO.put(Rating.class, ratingDAO);
        dbDAO.put(Reviews.class, reviewsDAO);
        dbDAO.put(User.class, uDAO);
    }
}
