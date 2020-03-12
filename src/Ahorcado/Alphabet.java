package Ahorcado;



public class Alphabet {



    private boolean[] ar = new boolean['z' - 'a' + 1];

    Alphabet() {

    }

    boolean isUsed(char c){
        c = Character.toLowerCase(c);
        if (c < 'a' || c > 'z') return false;
        return ar[c - 'a'];
    }
    boolean doGuess(char c){
        c = Character.toLowerCase(c);
        if (c < 'a' || c > 'z') return false;
        if (this.isUsed(c)) return true;
        this.ar[c-'a'] = true;
        return false;
    }


}
