package eins.service.impl;

import eins.dao.RatingDAO;
import eins.entity.Rating;
import eins.service.interfaces.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDAO dbDAO;

    @Override
    public void save(Rating o) {
        dbDAO.save(o);
    }

    @Override
    public Rating findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Rating> findAll() {
        return dbDAO.findAll();
    }
}