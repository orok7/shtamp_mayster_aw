package eins.service.impl;

import eins.dao.CarrierDAO;
import eins.entity.Carrier;
import eins.service.interfaces.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CarrierServiceImpl implements CarrierService {

    @Autowired
    CarrierDAO dbDAO;

    @Override
    public void save(Carrier o) {
        dbDAO.save(o);
    }

    @Override
    public Carrier findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Carrier> findAll() {
        return dbDAO.findAll();
    }
}
