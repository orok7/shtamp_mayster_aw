package eins.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_group")
public class ProductGroup {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;

        @ManyToOne(fetch = FetchType.EAGER)
        private ProductGroup parent;

        @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
        private Set<ProductGroup> subGroups = new HashSet<>();
}
