package eins.service.interfaces;

import eins.entity.City;

import java.util.List;

public interface CityService {

    void save(City o);

    City findOne(int id);

    List<City> findAll();

}
