package eins.dao.interfaces;

import eins.entity.Contacts;
import eins.entity.User;

import java.util.List;

public interface ContactsDAO {

    void save(Contacts contacts);

    Contacts findById(int id);

    List<Contacts> findAll();

}
