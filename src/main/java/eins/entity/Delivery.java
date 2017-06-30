package eins.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER)
    private Carrier carrier;
    @OneToOne(fetch = FetchType.EAGER)
    private CarrierDepartment carrierDepartment;
    private boolean isTargetedDelivery;
    @OneToOne(fetch = FetchType.EAGER)
    private Address targetAddress;
    private String declarationNumber;
}
