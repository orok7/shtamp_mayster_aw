package eins.service.interfaces;

import eins.entity.City;

import java.util.List;
import java.util.Map;

public interface CityService {

    void save(City o);

//    void save(Map<String,String> map) throws Exception;

    City findOne(int id);

    List<City> findAll();

}
