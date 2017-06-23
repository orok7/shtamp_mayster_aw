package eins.service.impl;

import eins.dao.PropertyDAO;
import eins.entity.Property;
import eins.service.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyDAO dbDAO;

    @Override
    public void save(Property o) {
        dbDAO.save(o);
    }

    @Override
    public Property findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Property> findAll() {
        return dbDAO.findAll();
    }
}