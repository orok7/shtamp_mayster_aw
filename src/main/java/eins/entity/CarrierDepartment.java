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
public class CarrierDepartment implements Mapable<CarrierDepartment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrier carrier;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @Override
    public String toString() {
        return (carrier == null)?"null":carrier.getName() + ", " + name + ", " + address;
    }

    @Override
    public CarrierDepartment parseFromMap(Map<String, String> map, DbService dbService) throws Exception {
        int id;

        String strId = map.get("id");
        String sCarrier = map.get("carrier");
        String name = map.get("name");
        String sAddress = map.get("address");
        int carrierId;
        int addressId;

        try { id = Integer.valueOf(strId); } catch (NumberFormatException e) { id = 0; }

        if (name == null) throw new Exception("Wrong map");

        Carrier carrier = null;
        try { carrierId = Integer.valueOf(sCarrier); } catch (NumberFormatException e) { carrierId = -1;}
        if (carrierId != -1) carrier = (Carrier) dbService.findOne(carrierId, Carrier.class);

        Address address = null;
        try { addressId = Integer.valueOf(sAddress); } catch (NumberFormatException e) { addressId = -1;}
        if (addressId != -1) address = (Address) dbService.findOne(addressId, Address.class);

        return new CarrierDepartment(id, carrier, name, address);
    }
}
