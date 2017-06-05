package entity;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @OneToOne(fetch = FetchType.LAZY)
    private Property property;
    @OneToOne(fetch = FetchType.LAZY)
    private PropertyValue propertyValue;

}
