package entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private boolean isCompany;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Contacts> contacts = new ArrayList<>();
    private String note;
    @CreationTimestamp
    private Timestamp dateOfRegistration;
    @UpdateTimestamp
    private Timestamp createTempPassword;
    @OneToOne(fetch = FetchType.LAZY)
    private CompanyUser companyDate;
    @OneToOne(fetch = FetchType.LAZY)
    private IndividualUser individualDate;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Invoice> invoices = new ArrayList<>();

    public User (String email, String password, boolean isCompany,
                 CompanyUser companyUser, IndividualUser individualUser,
                 Contacts contacts){
        login = email;
        this.password = password;
        this.isCompany = isCompany;
        companyDate = companyUser;
        individualDate = individualUser;
        this.contacts.add(contacts);
    };
}
