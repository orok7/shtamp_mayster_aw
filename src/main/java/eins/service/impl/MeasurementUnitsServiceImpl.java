package eins.service.impl;

import eins.dao.MeasurementUnitsDAO;
import eins.entity.MeasurementUnits;
import eins.service.interfaces.MeasurementUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class MeasurementUnitsServiceImpl implements MeasurementUnitsService {

    @Autowired
    MeasurementUnitsDAO dbDAO;

    @Override
    public void save(MeasurementUnits o) {
        dbDAO.save(o);
    }

    @Override
    public MeasurementUnits findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<MeasurementUnits> findAll() {
        return dbDAO.findAll();
    }
}