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
public class CarrierDepartment{
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

}
