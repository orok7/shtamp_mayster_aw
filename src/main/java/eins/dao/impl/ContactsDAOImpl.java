package eins.dao.impl;

import eins.dao.interfaces.ContactsDAO;
import eins.dao.interfaces.UserDAO;
import eins.entity.Contacts;
import eins.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("cDAO1")
@Transactional
public class ContactsDAOImpl implements ContactsDAO{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Contacts contacts) {
        if (contacts != null)
            manager.persist(contacts);
    }

    @Override
    public Contacts findById(int id) {
        return manager.find(Contacts.class,id);
    }

    @Override
    public List<Contacts> findAll() {
        return manager.createQuery("from Contacts c", Contacts.class).getResultList();
    }
}
