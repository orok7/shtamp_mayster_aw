package eins.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class OnlyForTesting {

    public static void main(String[] args) {
        String pass = "";
        Random r = new Random();
        List<Supplier<Integer>> funcs = new ArrayList<>();
        // number char code [48 - 57]
        funcs.add(() -> {return (r.nextInt(10)+48);});
        // bigger = 65 - 90
        funcs.add(() -> {return (r.nextInt(26)+65);});
        // smaller = 97 - 122
        funcs.add(() -> {return (r.nextInt(26)+97);});
        for (int i = 0; i < 6; i++){
            char ch = (char) (int) funcs.get(r.nextInt(3)).get();
            pass += ch;
        }
        System.out.println(pass);
    }

}
