package eins.service.impl;

import eins.dao.ContactsDAO;
import eins.entity.Contacts;
import eins.service.interfaces.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    ContactsDAO dbDAO;

    @Override
    public void save(Contacts o) {
        dbDAO.save(o);
    }

    @Override
    public Contacts findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<Contacts> findAll() {
        return dbDAO.findAll();
    }
}
