package eins.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    private int discount;
    private boolean isCompany;

    @CreationTimestamp
    private Timestamp dateOfRegistration;

    @UpdateTimestamp
    private Timestamp createTempPassword;
    private String tempPassword;

    private String name;
    private String surname;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private CompanyUser companyDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer", cascade = CascadeType.MERGE)
    private List<Invoice> invoices = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Reviews> reviews = new ArrayList<>();



    ///////////////////////////////////////////////////////////////////////////
    //  Methods implementation for security
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Constructors, getters, setters and another standard methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Timestamp getCreateTempPassword() {
        return createTempPassword;
    }

    public void setCreateTempPassword(Timestamp createTempPassword) {
        this.createTempPassword = createTempPassword;
    }

    public CompanyUser getCompanyDate() {
        return companyDate;
    }

    public void setCompanyDate(CompanyUser companyDate) {
        this.companyDate = companyDate;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public User (String email, String password, boolean isCompany,
                 CompanyUser companyUser){
        username = email;
        this.password = password;
        this.isCompany = isCompany;
        companyDate = companyUser;
    }

    public User() {
    }

    public User(String username, String password, Role role, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, int discount, boolean isCompany, Timestamp dateOfRegistration, Timestamp createTempPassword, String tempPassword, String name, String surname, CompanyUser companyDate, List<Invoice> invoices) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.discount = discount;
        this.isCompany = isCompany;
        this.dateOfRegistration = dateOfRegistration;
        this.createTempPassword = createTempPassword;
        this.tempPassword = tempPassword;
        this.name = name;
        this.surname = surname;
        this.companyDate = companyDate;
        this.invoices = invoices;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Special getter for spring forms
    ///////////////////////////////////////////////////////////////////////////

    public boolean getIsCompany() {
        return isCompany;
    }

}
