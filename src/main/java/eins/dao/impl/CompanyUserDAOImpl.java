package eins.dao.impl;

import eins.dao.interfaces.CompanyUserDAO;
import eins.dao.interfaces.ContactsDAO;
import eins.entity.CompanyUser;
import eins.entity.Contacts;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CompanyUserDAOImpl implements CompanyUserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(CompanyUser companyUser) {
        if (companyUser != null)
            manager.persist(companyUser);
    }

    @Override
    public CompanyUser findById(int id) {
        return manager.find(CompanyUser.class,id);
    }

    @Override
    public List<CompanyUser> findAll() {
        return manager.createQuery("from CompanyUser", CompanyUser.class).getResultList();
    }
}
