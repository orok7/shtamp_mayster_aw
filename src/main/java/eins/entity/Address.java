package eins.entity;

import eins.service.interfaces.DbService;
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
    @OneToOne(fetch = FetchType.LAZY)
    private City city;
    private String street;
    private String building;
    private int room;

    @Override
    public String toString() {
        return city + ", вул." + street +
                ", " + building +
                "/ " + room;
    }

    @Override
    public Address parseFromMap(Map<String, String> map, DbService dbService) throws Exception {
        int id;

        String strId = map.get("id");
        String sCityId = map.get("city");
        String street = map.get("street");
        String building = map.get("building");
        String sRoom = map.get("room");
        int iRoom;
        int iCityId;

        try { id = Integer.valueOf(strId); } catch (NumberFormatException e) {id = 0;}

        City city = null;
        try { iCityId = Integer.valueOf(sCityId); } catch (NumberFormatException e) { iCityId = -1;}
        if (iCityId != -1) city = (City) dbService.findOne(iCityId, City.class);

        if (street == null || building == null) throw new Exception("Wrong map");

        try { iRoom = Integer.valueOf(sRoom); } catch (NumberFormatException e) {iRoom = 0;}

        return new Address(id,city,street,building,iRoom);
    }
}
