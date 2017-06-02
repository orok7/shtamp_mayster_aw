package entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String tempPassword;
    private int discount;
    @OneToMany
    private List<Contacts> contacts = new ArrayList<>();
    private String note;
    private Timestamp dateOfRegistration;
}
