package eins.service.interfaces;

import eins.entity.Characteristic;

import java.util.List;

public interface CharacteristicService {

    void save(Characteristic o);

    Characteristic findOne(int id);

    List<Characteristic> findAll();

}
