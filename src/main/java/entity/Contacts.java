package entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phoneNumber;
    @OneToOne
    private Carrier carrier;
    @OneToOne
    private CarrierDepartment carrierDepartment;
    @OneToOne
    private Address homeAddress;
}
