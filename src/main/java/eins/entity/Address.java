package eins.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Address {
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
}
