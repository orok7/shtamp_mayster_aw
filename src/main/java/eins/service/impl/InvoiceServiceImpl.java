package eins.service.impl;

import eins.dao.InvoiceDAO;
import eins.entity.Invoice;
import eins.service.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceDAO dbDAO;

    @Override
    public void save(Invoice o) {
        dbDAO.save(o);
    }

    @Override
    public Invoice findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Invoice> findAll() {
        return dbDAO.findAll();
    }
}