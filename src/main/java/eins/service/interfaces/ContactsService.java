package eins.service.interfaces;

import eins.entity.Contacts;

import java.util.List;

public interface ContactsService {

    void save(Contacts o);

    Contacts findOne(int id);

    List<Contacts> findAll();

}
