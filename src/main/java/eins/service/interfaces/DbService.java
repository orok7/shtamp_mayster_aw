package eins.service.interfaces;

import java.util.List;
import java.util.Map;

public interface DbService {

    void save(Object o, Class<?> clazz);

//    void save(Map<String, String> map, Class<?> clazz) throws Exception;

    Object findOne(int id, Class<?> clazz);

    List<Object> findAll(Class<?> clazz);

}
