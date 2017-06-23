package eins.service.impl;

import eins.dao.PaymentTypeDAO;
import eins.entity.PaymentType;
import eins.service.interfaces.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeDAO dbDAO;

    @Override
    public void save(PaymentType o) {
        dbDAO.save(o);
    }

    @Override
    public PaymentType findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<PaymentType> findAll() {
        return dbDAO.findAll();
    }
}