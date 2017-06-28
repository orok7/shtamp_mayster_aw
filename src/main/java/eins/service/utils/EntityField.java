package eins.service.utils;

import eins.service.interfaces.DbService;
import lombok.*;

import java.lang.reflect.Field;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class EntityField {

    private Class<?> fieldType;
    private String fieldName;
    private String fieldStringValue;
    private String inputType;
    private Object fieldObjectValue;

    public EntityField(Field f, DbService dbService) throws ClassNotFoundException {
        init(f, dbService);
    }

    public EntityField init(Field f, DbService dbService) throws ClassNotFoundException {
        fieldType = f.getType();
        fieldName = f.getName();
        initInputType(f, dbService);
        return this;
    }

    public EntityField init(Field f, String val, DbService dbService) throws ClassNotFoundException {
        this.init(f, dbService);
        fieldStringValue = val;
        return this;
    }

    public EntityField initInputType(Field f, DbService dbService) throws ClassNotFoundException {

        if (Collection.class.isAssignableFrom(f.getType())) {
            inputType = "multi-select";
            fieldType = getGenericType(f);
            fieldObjectValue = dbService.findAll(fieldType);
            return this;
        }

        if (f.getType().getName().startsWith("eins.entity")) {
            inputType = "select";
            fieldObjectValue = dbService.findAll(f.getType());
            return this;
        }

        switch (f.getType().getSimpleName().toLowerCase()) {

            case "double": case "int":
            case "float": case "byte":
            case "short": case "long":
            case "integer":
                if (f.getName().equalsIgnoreCase("id")) inputType = "hidden";
                else inputType = "number";
                break;

            case "datetime": case "timestamp":
                inputType = "datetime";
                break;

            case "date":
                inputType = "date";
                break;

            case "string": if (f.getName().equalsIgnoreCase("path"))
                inputType = "file";
                else
                inputType =  "text";
                break;

            default: inputType =  "text";
        }

        return this;

    }

    /*
    public static EntityField newInstance(Field f) throws ClassNotFoundException {
        Class<?> type = f.getType();
        String name = f.getName();
        boolean isCollection = false;
        Object fieldObjectValue = null;
        if (Collection.class.isAssignableFrom(f.getType())) {
            isCollection = true;
            type = getGenericType(f);
            fieldObjectValue = new EntityField().dbService.findAll(type);
        }
        String typeForInput = initInputType(type, name);
        return EntityField.builder()
                .fieldType(type)
                .fieldName(name)
                .inputType(typeForInput)
                .isCollection(isCollection)
                .fieldObjectValue(fieldObjectValue)
                .build();
    }
    */

    public static Class<?> getGenericType (Field f) throws ClassNotFoundException {
        Class<?> clazz = f.getType();
        String tn = f.getGenericType().getTypeName();
        if (!clazz.isPrimitive() && !tn.replace(clazz.getName(),"").isEmpty()){
            String res = tn.substring(tn.indexOf('<')+1, tn.indexOf('>'));
            return Class.forName(res);
        }
        return clazz;
    }

    @Override
    public String toString() {
        return "\n\n\tType: " + fieldType.getSimpleName() +
                "\n\tName: " + fieldName +
                "\n\tValue: " + fieldStringValue +
                "\n\tObjValue: " + fieldObjectValue +
                "\n\tInputType: " + inputType;
    }
}