package eins.testing;


import eins.entity.City;
import eins.service.utils.ClassUtil;
import eins.service.utils.SomeClass;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class OnlyForTesting {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, IOException, InvocationTargetException, InstantiationException, NoSuchFieldException, ParseException {

        SomeClasss s = new SomeClasss();

        Date date = parseDate("02-07-2017");

        System.out.println(date);

    }

    private static Date parseDate(String sDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date parse = df.parse(sDate);
        return parse;
    }

}
