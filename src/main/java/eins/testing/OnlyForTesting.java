package eins.testing;


import eins.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

public class OnlyForTesting {

    public static void main(String[] args) throws NoSuchMethodException {

        String in = "9@&10@&13@&15@&";

        int i=0;

        for (String s : in.split("@&")) {
            System.out.println(++i + ": " + s);
        }
    }

}
