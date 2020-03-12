package Ahorcado;

public class Main {
    public static void main(String[] args) {

        HangMan hg = new HangMan(new DictWordFactory());
        hg.play();



    }
}
