package eins.testing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SomeClasss{
    private String s;

    public void doSome() {
        System.out.println("I do this " + s);
    }
}
