package eins.service.interfaces;

import eins.entity.Delivery;

import java.util.List;

public interface DeliveryService {

    void save(Delivery o);

    Delivery findOne(int id);

    List<Delivery> findAll();

}
