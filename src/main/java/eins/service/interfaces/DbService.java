package eins.service.interfaces;

import java.util.List;

public interface DbService {

    void save(Object o, Class<?> clazz);

    List<Object> findAll(Class<?> clazz);

}
