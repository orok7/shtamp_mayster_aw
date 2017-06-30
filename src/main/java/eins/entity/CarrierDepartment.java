package eins.entity;

import eins.service.interfaces.DbService;
import eins.service.utils.Mapable;
import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class CarrierDepartment implements Mapable<CarrierDepartment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Carrier carrier;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    private Address address;

    @Override
    public String toString() {
        return (carrier == null)?"null":carrier.getName() + ", " + name + ", " + address;
    }

    @Override
    public CarrierDepartment parseFromMap(Map<String, String> map, DbService dbService){

        String name = map.get("name");

        int id = checkInt(map.get("id"));

        Carrier carrier = (Carrier) checkObject(map.get("carrier"), dbService, Carrier.class);

        Address address = (Address) checkObject(map.get("address"), dbService, Address.class);

        return new CarrierDepartment(id, carrier, name, address);
    }
}
