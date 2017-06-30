package eins.testing;


import eins.service.utils.ClassUtil;

import java.io.IOException;
import java.util.List;

public class OnlyForTesting {

    public static void main(String[] args) throws NoSuchMethodException {

        List<String> list = null;
        try {
            list = ClassUtil.getNames("eins.entity", "");
            list.add(0,"- Please select table -");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }

}
