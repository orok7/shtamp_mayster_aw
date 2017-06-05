package entity;

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
    @OneToOne(fetch = FetchType.LAZY)
    private Carrier carrier;
    @OneToOne(fetch = FetchType.LAZY)
    private CarrierDepartment carrierDepartment;
    private boolean isTargetedDelivery;
    @OneToOne(fetch = FetchType.LAZY)
    private Address targetAddress;
    private String declarationNumber;
}
