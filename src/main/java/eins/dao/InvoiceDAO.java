package eins.dao;

import eins.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDAO extends JpaRepository<Invoice,Integer> {


}
