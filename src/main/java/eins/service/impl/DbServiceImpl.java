package eins.service.impl;

import eins.dao.DbDAO;
import eins.service.interfaces.DbService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbServiceImpl<T> implements DbService<T> {

    DbDAO<T> dbDAO;

    @Override
    public void save(T o) {
        dbDAO.save(o);
    }

    @Override
    public T findOne(int id) {
        return dbDAO.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return dbDAO.findAll();
    }
}
