package eins.service.interfaces;

import eins.entity.MeasurementUnits;

import java.util.List;

public interface MeasurementUnitsService {

    void save(MeasurementUnits o);

    MeasurementUnits findOne(int id);

    List<MeasurementUnits> findAll();

}
