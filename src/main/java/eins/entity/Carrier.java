package eins.entity;

import eins.service.interfaces.DbService;
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
    @OneToMany(fetch = FetchType.LAZY)
    private List<CarrierDepartment> departments = new ArrayList<>();

    @Override
    public Carrier parseFromMap(Map<String, String> map, DbService dbService) throws Exception {
        int id;

        String strId = map.get("id");
        String name = map.get("name");
        String sDepartments = map.get("departments");
        List<CarrierDepartment> departments = new ArrayList<>();

        try { id = Integer.valueOf(strId); } catch (NumberFormatException e) { id = 0; }

        if (name == null) throw new Exception("Wrong map");

        if (sDepartments != null && !sDepartments.isEmpty()){
            for (String s :sDepartments.split("@&")){
                int depId;
                try {
                    depId = Integer.valueOf(s);
                    departments.add((CarrierDepartment) dbService.findOne(depId, CarrierDepartment.class));
                }
                catch (NumberFormatException e) {  }
            }
        }

        return new Carrier(id, name, departments);
    }
}
