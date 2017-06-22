package eins.service.interfaces;

import eins.entity.PropertyValue;

import java.util.List;

public interface PropertyValueService {

    void save(PropertyValue o);

    PropertyValue findOne(int id);

    List<PropertyValue> findAll();

}
