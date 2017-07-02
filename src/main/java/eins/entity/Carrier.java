package eins.entity;

import eins.service.interfaces.DbService;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Carrier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<CarrierDepartment> departments = new ArrayList<>();

    @Override
    public String toString() {
        return name;
    }
}
