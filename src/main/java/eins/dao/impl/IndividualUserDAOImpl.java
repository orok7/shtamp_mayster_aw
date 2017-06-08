package eins.dao.impl;

import eins.dao.interfaces.CompanyUserDAO;
import eins.dao.interfaces.IndividualUserDAO;
import eins.entity.CompanyUser;
import eins.entity.IndividualUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class IndividualUserDAOImpl implements IndividualUserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(IndividualUser individualUser) {
        System.out.println("in iu save");
        if (individualUser != null)
            System.out.println("in iu pers");
            manager.persist(individualUser);
    }

    @Override
    public IndividualUser findById(int id) {
        return manager.find(IndividualUser.class,id);
    }

    @Override
    public List<IndividualUser> findAll() {
        return manager.createQuery("from IndividualUser u", IndividualUser.class).getResultList();
    }
}
