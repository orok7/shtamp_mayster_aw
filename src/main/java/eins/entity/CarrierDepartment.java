package eins.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class CarrierDepartment {
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
        return carrier.getName() + ", " + name + ", " + address;
    }
}
