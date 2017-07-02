package eins.service.utils;

import eins.service.interfaces.DbService;
import lombok.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public Object getInstance(DbService dbService) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            NoSuchFieldException, ClassNotFoundException, ParseException {

        if (fields == null || entityClass == null) return null;

        Object o = ClassUtil.newInstance(entityClass);
        for (EntityField field : fields) {
            parseThis(o, field, dbService);
        }


        return o;
    }

    private void parseThis(Object inner, EntityField field, DbService dbService)
            throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException, InstantiationException, InvocationTargetException,
            ParseException {

        Field objField = entityClass.getDeclaredField(field.getFieldName());
        objField.setAccessible(true);

        if (Number.class.isAssignableFrom(objField.getType())) {
            parseNumber(inner, field.getFieldStringValue(), field.getFieldName());
            return;
        }

        if (field.getFieldType().getName().startsWith("eins.entity")) {
            objField.set(inner, parseObject(field.getFieldStringValue(), dbService, field.getFieldType()));
            return;
        }

        if (Collection.class.isAssignableFrom(objField.getType())){
            objField.set(inner, parseObject(field.getFieldStringValue(), dbService, field.getFieldType()));
            return;
        }

        if (Boolean.class.isAssignableFrom(objField.getType())) {
            objField.set(inner, field.getFieldStringValue().equalsIgnoreCase("true"));
            return;
        }

        if (Date.class.isAssignableFrom(objField.getType())) {
            objField.set(inner, parseDate(field.getFieldStringValue()));
            return;
        }

        if (String.class.isAssignableFrom(objField.getType()))
            objField.set(inner, field.getFieldStringValue());

    }

    private Date parseDate(String sDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = df.parse(sDate);
        return parse;
    }

    private void parseNumber (Object inner, String val, String fieldName) throws ClassNotFoundException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {

        Class<?> innerClass = inner.getClass();
        Field f = innerClass.getDeclaredField(fieldName);
        f.setAccessible(true);

        String classFullName = "java.lang.";
        Class<?> ftype = f.getType();

        if (!ftype.isPrimitive()){
            if (Number.class.isAssignableFrom(ftype)) {
                classFullName += ftype.getSimpleName();

            } else return;
        }else {
            String fTypeName = ftype.getSimpleName();

            if (fTypeName.equalsIgnoreCase("int"))
                classFullName = "Integer";

            else classFullName += fTypeName.substring(0, 1).toUpperCase() +
                    fTypeName.substring(1);
        }

        Class<?> cNum = Class.forName(classFullName);
        Object o;
        try { o = cNum.getConstructor(String.class).newInstance(val); }
        catch (Exception e)
        { o = cNum.getConstructor(String.class).newInstance("0"); }

        f.set(inner, o);

    }

    private int checkInt(String strInt){
        int Int;
        try { Int = Integer.valueOf(strInt); } catch (NumberFormatException e) {Int = 0;}
        return Int;
    }

    private Object parseObject(String strId, DbService dbService, Class<?> clazz){
        int id;
        try { id = Integer.valueOf(strId); } catch (NumberFormatException e) { id = -1;}
        if (id != -1) return dbService.findOne(id, clazz);
        return null;
    }

    private <TT> void parseObjects(String strIds, List<TT> list, DbService dbService, Class<?> clazz){
        if (strIds != null && !strIds.isEmpty()){
            for (String s :strIds.split("@&")){
                int depId;
                try {
                    depId = Integer.valueOf(s);
                    list.add((TT)dbService.findOne(depId, clazz));
                }
                catch (NumberFormatException e) {  }
            }
        }
    }

    @Override
    public String toString() {
        return "\n\nClass: " + ((entityClass == null)?"null":entityClass.getName()) +
                "\nFields:" + fields;
    }
}
