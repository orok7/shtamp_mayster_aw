package eins.service.impl;

import eins.dao.CharacteristicDAO;
import eins.entity.Characteristic;
import eins.service.interfaces.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CharacteristicServiceImpl implements CharacteristicService {

    @Autowired
    CharacteristicDAO dbDAO;

    @Override
    public void save(Characteristic o) {
        dbDAO.save(o);
    }

    @Override
    public Characteristic findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Characteristic> findAll() {
        return dbDAO.findAll();
    }
}
