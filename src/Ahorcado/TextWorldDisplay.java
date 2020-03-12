package Ahorcado;

import java.util.Arrays;

public class TextWorldDisplay implements WordDisplay{
    public void display(Word w){
        StringBuilder string;
        System.out.println(Arrays.toString(w.charword));
    }

}
