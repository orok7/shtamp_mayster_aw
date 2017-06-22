package eins.service.interfaces;

import java.util.List;

public interface DbService<T> {

    void save(T o);

    T findOne(int id);

    List<T> findAll();

}
