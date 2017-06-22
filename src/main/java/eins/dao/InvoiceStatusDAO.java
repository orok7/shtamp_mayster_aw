package eins.dao;

import eins.entity.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusDAO extends JpaRepository<InvoiceStatus,Integer> {


}
