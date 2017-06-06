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
    @OneToOne(fetch = FetchType.LAZY)
    private ProductGroup productGroup;
    private String article;
    private String name;
    private boolean hasCharacteristic;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Characteristic> characteristics = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    private MeasurementUnits measurementUnits;
    private double price;
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY)
    private List<Rating> ratings = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY)
    private List<Reviews> reviews = new ArrayList<>();
}
