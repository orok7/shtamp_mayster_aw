package eins.dao.interfaces;

import eins.entity.IndividualUser;
import eins.entity.User;

import java.util.List;

public interface IndividualUserDAO {

    void save(IndividualUser individualUser);

    IndividualUser findById(int id);

    List<IndividualUser> findAll();

}
