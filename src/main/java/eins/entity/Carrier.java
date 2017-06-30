package eins.entity;

import eins.service.interfaces.DbService;
import eins.service.utils.Mapable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Carrier implements Mapable<Carrier> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<CarrierDepartment> departments = new ArrayList<>();

    @Override
    public Carrier parseFromMap(Map<String, String> map, DbService dbService) {

        String name = map.get("name");

        int id = checkInt(map.get("id"));

        List<CarrierDepartment> departments = new ArrayList<>();
        checkObjects(map.get("departments"), departments, dbService, CarrierDepartment.class);

        return new Carrier(id, name, departments);
    }

    @Override
    public String toString() {
        return name;
    }
}
