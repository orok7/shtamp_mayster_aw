package eins.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private ProductGroup productGroup;

    @Column(unique = true)
    private String article;
    private String name;

    @Enumerated(EnumType.STRING)
    private MeasurementUnits measurementUnits = MeasurementUnits.SHT;

    private double price;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Image> images = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.MERGE)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.MERGE)
    private List<Reviews> reviews = new ArrayList<>();

}
