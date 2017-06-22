package eins.service.interfaces;

import eins.entity.Address;

import java.util.List;

public interface AddressService {

    void save(Address o);

    Address findOne(int id);

    List<Address> findAll();

}
