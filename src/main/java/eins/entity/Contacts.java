package eins.entity;

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
    @OneToOne(fetch = FetchType.EAGER)
    private Carrier carrier;
    @OneToOne(fetch = FetchType.EAGER)
    private CarrierDepartment carrierDepartment;
    @OneToOne(fetch = FetchType.EAGER)
    private Address homeAddress;

    public Contacts (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + phoneNumber;
    }
}
