package eins.service.interfaces;

import eins.entity.IndividualUser;

import java.util.List;

public interface IndividualUserService {

    void save(IndividualUser o);

    IndividualUser findOne(int id);

    List<IndividualUser> findAll();

}
