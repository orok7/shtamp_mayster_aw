package eins.service.impl;

import eins.dao.PropertyValueDAO;
import eins.entity.PropertyValue;
import eins.service.interfaces.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PropertyValueServiceImpl implements PropertyValueService {

    @Autowired
    PropertyValueDAO dbDAO;

    @Override
    public void save(PropertyValue o) {
        dbDAO.save(o);
    }

    @Override
    public PropertyValue findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<PropertyValue> findAll() {
        return dbDAO.findAll();
    }
}