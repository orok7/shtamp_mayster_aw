package eins.service.impl;

import eins.dao.CityDAO;
import eins.entity.City;
import eins.service.interfaces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    CityDAO dbDAO;

    @Override
    public void save(City o) {
        dbDAO.save(o);
    }

    /*@Override
    public void save(Map<String, String> map) throws Exception {
        dbDAO.save(City.parseFromMap(map));
    }*/

    @Override
    public City findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<City> findAll() {
        return dbDAO.findAll();
    }
}
