package eins.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class OnlyForTesting {

    public static void main(String[] args) {

        try {
            String value = "29.1";
            System.out.println((Float.valueOf(value) + 1.0) == 30.1);
            System.out.println((Double.valueOf(value) + 1.0) == 30.1);
            System.out.println(Float.valueOf(value)/0);
            System.out.println(Double.valueOf(value)/0);
        }
        catch (NumberFormatException ex) {
            System.out.println("NumberFormatException");
        }
        catch (ArithmeticException ex) {
            System.out.println("ArithmeticException");
        }

    }

}
