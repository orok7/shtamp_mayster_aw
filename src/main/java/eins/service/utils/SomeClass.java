package eins.service.utils;

import eins.service.interfaces.DbService;
import lombok.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

//    public static SomeClass newInstance(String classFullName, DbService dbService) throws ClassNotFoundException {
//        SomeClass someClass = new SomeClass();
//        someClass.init(classFullName, dbService);
//        return someClass;
//    }

    @Override
    public String toString() {
        return "\n\nClass: " + entityClass.getName() +
                "\nFields:" + fields;
    }
}
