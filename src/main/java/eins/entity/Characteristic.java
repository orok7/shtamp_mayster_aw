package eins.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    @OneToOne(fetch = FetchType.EAGER)
    private Property property;
    @OneToOne(fetch = FetchType.EAGER)
    private PropertyValue propertyValue;

    @Override
    public String toString() {
        return property.getName() + propertyValue.getValue();
    }
}
