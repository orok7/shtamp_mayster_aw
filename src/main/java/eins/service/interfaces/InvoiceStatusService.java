package eins.service.interfaces;

import eins.entity.InvoiceStatus;

import java.util.List;

public interface InvoiceStatusService {

    void save(InvoiceStatus o);

    InvoiceStatus findOne(int id);

    List<InvoiceStatus> findAll();

}
