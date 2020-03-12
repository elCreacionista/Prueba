package Ahorcado;

import java.util.Random;

public class DictWordFactory implements WordFactory{


    private String[] dict = new String[]{
            "CASA", "PALABRA", "DICCIONARIO", "QUESO", "AHORCADO", "COCAINA", "ESPECIAS", "ESPAGUETIS", "COMIDA", "ALANDALUS", "GUSANO",
            "DICTADO"
    };


    @Override
    public Word makeWord() {

        return new Word(dict[(int)(Math.random()*11)]);
    }
}
