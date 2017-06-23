package eins.service.impl;

import eins.dao.DeliveryDAO;
import eins.entity.Delivery;
import eins.service.interfaces.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryDAO dbDAO;

    @Override
    public void save(Delivery o) {
        dbDAO.save(o);
    }

    @Override
    public Delivery findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Delivery> findAll() {
        return dbDAO.findAll();
    }
}