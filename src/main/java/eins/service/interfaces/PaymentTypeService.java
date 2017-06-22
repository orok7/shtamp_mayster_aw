package eins.service.interfaces;

import eins.entity.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    void save(PaymentType o);

    PaymentType findOne(int id);

    List<PaymentType> findAll();

}
