package eins.service.impl;

import eins.dao.IndividualUserDAO;
import eins.entity.IndividualUser;
import eins.service.interfaces.IndividualUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class IndividualUserServiceImpl implements IndividualUserService {

    @Autowired
    IndividualUserDAO dbDAO;

    @Override
    public void save(IndividualUser o) {
        dbDAO.save(o);
    }

    @Override
    public IndividualUser findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<IndividualUser> findAll() {
        return dbDAO.findAll();
    }
}