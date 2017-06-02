package entity;

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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private User buyer;
    private Date date;
    @OneToMany
    private List<ProductToBuy> products = new ArrayList<>();
    private double sum;
    private String note;
    @OneToOne
    private OrderStatus status;
    private double payed;
    @OneToOne
    private PaymentType paymentType;
    @OneToOne
    private Delivery delivery;
}
