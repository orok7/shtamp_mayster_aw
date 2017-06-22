package eins.service.impl;

import eins.dao.AddressDAO;
import eins.entity.Address;
import eins.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDAO dbDAO;

    @Override
    public void save(Address o) {
        dbDAO.save(o);
    }

    @Override
    public Address findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Address> findAll() {
        return dbDAO.findAll();
    }
}
