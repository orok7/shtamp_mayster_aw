package eins.dao;

import eins.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City,Integer> {


}
