package Ahorcado;

public class DefaultWordFactory implements WordFactory{
    @Override
    public Word makeWord() {
        return new Word("SUPERCALIFRAGILISTICOESPIALIDOSO");
    }
}
