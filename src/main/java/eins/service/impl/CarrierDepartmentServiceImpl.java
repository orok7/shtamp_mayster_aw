package eins.service.impl;

import eins.dao.CarrierDepartmentDAO;
import eins.entity.CarrierDepartment;
import eins.service.interfaces.CarrierDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CarrierDepartmentServiceImpl implements CarrierDepartmentService {

    @Autowired
    CarrierDepartmentDAO dbDAO;

    @Override
    public void save(CarrierDepartment o) {
        dbDAO.save(o);
    }

    @Override
    public CarrierDepartment findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<CarrierDepartment> findAll() {
        return dbDAO.findAll();
    }
}
