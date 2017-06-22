package eins.service.interfaces;

import eins.entity.Carrier;

import java.util.List;

public interface CarrierService {

    void save(Carrier o);

    Carrier findOne(int id);

    List<Carrier> findAll();

}
