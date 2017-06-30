package eins.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;
    private Date date;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductToBuy> products = new ArrayList<>();
    private double sum;
    private String note;
    @OneToOne(fetch = FetchType.EAGER)
    private InvoiceStatus status;
    private double payed;
    @OneToOne(fetch = FetchType.EAGER)
    private PaymentType paymentType;
    @OneToOne(fetch = FetchType.EAGER)
    private Delivery delivery;

    @Override
    public String toString() {
        return buyer.getLogin() + " " + date + " " + sum + " грн.";
    }
}
