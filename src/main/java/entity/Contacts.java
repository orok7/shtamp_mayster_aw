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
    private String name;
    private String surname;
    private String phoneNumber;
    @OneToOne(fetch = FetchType.LAZY)
    private Carrier carrier;
    @OneToOne(fetch = FetchType.LAZY)
    private CarrierDepartment carrierDepartment;
    @OneToOne(fetch = FetchType.LAZY)
    private Address homeAddress;

    public Contacts (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
