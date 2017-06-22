package eins.service.interfaces;

import eins.entity.Property;

import java.util.List;

public interface PropertyService {

    void save(Property o);

    Property findOne(int id);

    List<Property> findAll();

}
