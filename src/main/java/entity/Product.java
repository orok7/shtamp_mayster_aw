package entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Group group;
    private String article;
    private String name;
    private boolean hasCharacteristic;
    @OneToMany
    private List<Characteristic> characteristics = new ArrayList<>();
    @OneToOne
    private MeasurementUnits measurementUnits;
    private double price;
    private String description;
    @OneToMany
    private List<Image> images = new ArrayList<>();
}
