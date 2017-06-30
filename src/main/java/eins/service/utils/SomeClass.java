package eins.service.utils;

import eins.service.interfaces.DbService;
import lombok.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.log4j.lf5.util.LogMonitorAdapter.newInstance;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SomeClass {

    private Class<?> entityClass;
    private List<EntityField> fields = new ArrayList<>();

    public SomeClass init(String classFullName, DbService dbService) throws ClassNotFoundException {
        entityClass = Class.forName(classFullName);
        Field[] fs = entityClass.getDeclaredFields();
        for (Field f : fs) {
            EntityField field = new EntityField(f, dbService);
            fields.add(field);
        }
        return this;
    }

    public SomeClass(String classFullName, DbService dbService) throws ClassNotFoundException {
        init(classFullName, dbService);
    }

    public Map<String,String> getFieldsMap(){
        if (fields == null || entityClass == null) return null;
        Map<String,String> map = new HashMap<>();
        for (EntityField ef: fields)
            map.put(ef.getFieldName(),ef.getFieldStringValue());
        return map;
    }

    /*public <T> T getObjectFromMap(Map<String,String> map){
        return null;
    }*/

//    public Object getInstance(DbService dbService) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        if (fields == null || entityClass == null) return null;
//
//        Constructor<?> allArgs = null;
//        Constructor<?>[] constructors = entityClass.getConstructors();
//        for (Constructor<?> con: constructors) {
//            if (fields.size() == con.getParameterCount()) {
//                allArgs = con;
//            }
//        }
//        if (allArgs == null) return null;
//
//        Parameter[] parameters = allArgs.getParameters();
//        Object o = allArgs.newInstance(-1, -2, -3);
//
//        return o;
//    }

    @Override
    public String toString() {
        return "\n\nClass: " + ((entityClass == null)?"null":entityClass.getName()) +
                "\nFields:" + fields;
    }
}
