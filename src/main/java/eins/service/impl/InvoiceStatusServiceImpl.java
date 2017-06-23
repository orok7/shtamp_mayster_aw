package eins.service.impl;

import eins.dao.InvoiceStatusDAO;
import eins.entity.InvoiceStatus;
import eins.service.interfaces.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class InvoiceStatusServiceImpl implements InvoiceStatusService {

    @Autowired
    InvoiceStatusDAO dbDAO;

    @Override
    public void save(InvoiceStatus o) {
        dbDAO.save(o);
    }

    @Override
    public InvoiceStatus findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<InvoiceStatus> findAll() {
        return dbDAO.findAll();
    }
}