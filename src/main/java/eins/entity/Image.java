package eins.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;

    @Override
    public String toString() {
        return path.substring(path.lastIndexOf('/')+1);
    }
}
