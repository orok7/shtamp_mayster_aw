package eins.dao;

import eins.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface CityDAO extends JpaRepository<City,Integer> {

    /*default public void saveMap (Map<String, String> map) throws Exception {
        this.save(City.parseFromMap(map));
    }*/

}
