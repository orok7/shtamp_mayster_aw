package eins.service.impl;

import eins.dao.ReviewsDAO;
import eins.entity.Reviews;
import eins.service.interfaces.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    ReviewsDAO dbDAO;

    @Override
    public void save(Reviews o) {
        dbDAO.save(o);
    }

    @Override
    public Reviews findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Reviews> findAll() {
        return dbDAO.findAll();
    }
}