package eins.service.interfaces;

import eins.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    void save(Invoice o);

    Invoice findOne(int id);

    List<Invoice> findAll();

}
