package Ahorcado;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TextAlphabetDisplay implements AlphabetDisplay{
    @Override
    public void display(Alphabet a) {

        StringBuilder resultat = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++){
            if (a.isUsed(c))
                resultat.append(c).append(" - ");
        }
        System.out.println(resultat.toString());
    }
}
