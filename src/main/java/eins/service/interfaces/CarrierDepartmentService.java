package eins.service.interfaces;

import eins.entity.CarrierDepartment;

import java.util.List;

public interface CarrierDepartmentService {

    void save(CarrierDepartment o);

    CarrierDepartment findOne(int id);

    List<CarrierDepartment> findAll();

}
