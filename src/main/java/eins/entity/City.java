package eins.entity;

import eins.service.interfaces.DbService;
import eins.service.utils.Mapable;
import lombok.*;

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
    public City parseFromMap(Map<String, String> map, DbService dbService){

        String name = map.get("name");

        int id = checkInt(map.get("id"));

        return new City(id,name);
    }

    @Override
    public String toString() {
        return name;
    }
}
