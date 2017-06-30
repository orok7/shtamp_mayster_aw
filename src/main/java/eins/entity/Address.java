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
public class Address implements Mapable<Address> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    private City city;
    private String street;
    private String building;
    private int room;

    @Override
    public String toString() {
        return /*city + */", вул." + street +
                ", " + building +
                "/ " + room;
    }

    @Override
    public Address parseFromMap(Map<String, String> map, DbService dbService){

        String street = map.get("street");
        String building = map.get("building");

        int id = checkInt(map.get("id"));

        City city = (City) checkObject(map.get("city"), dbService, City.class);

        int iRoom = checkInt(map.get("room"));

        return new Address(id,city,street,building,iRoom);
    }
}
