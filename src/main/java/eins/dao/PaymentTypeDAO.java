package eins.dao;

import eins.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeDAO extends JpaRepository<PaymentType,Integer> {


}
