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
    @OneToOne
    private Carrier carrier;
    @OneToOne
    private CarrierDepartment carrierDepartment;
    private boolean isTargetedDelivery;
    @OneToOne
    private Address targetAddress;
    private String declarationNumber;
}
