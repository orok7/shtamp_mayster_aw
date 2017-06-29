package eins.entity;

import eins.service.interfaces.CityService;
import eins.service.interfaces.DbService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
//@Builder
public class City implements Mapable<City> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Override
    public City parseFromMap(Map<String, String> map, DbService dbService) throws Exception {
        int id;

        String strId = map.get("id");
        String name = map.get("name");

        if (name == null) throw new Exception("Wrong map");

        try { id = Integer.valueOf(strId); } catch (NumberFormatException e) {id = 0;}

        return new City(id,name);
    }

    @Override
    public String toString() {
        return name;
    }
}
