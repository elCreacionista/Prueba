package Ahorcado;

public class Word {

    private String wstring;
    char[] charword;


    Word(String s){
        this.wstring = s.toUpperCase();
        this.charword = new char[s.length()];
        for (int i = 0; i <charword.length ; i++) {
            this.charword[i] = '-';
        }
    }

    @Override
    public String toString(){
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < wstring.length() ; i++) {
            p.append(wstring.charAt(i));
            p.append("-");
        }
        return p.toString();
    }

    boolean idGuessed(){

        for (int i = 0; i <charword.length ; i++) {
            if (charword[i] == '-')
                return false;
        }
        return true;
    }
    boolean doGuess(char c){
        c = Character.toUpperCase(c);
        boolean acertado = false;
        for (int i = 0; i <charword.length ; i++) {
            if (wstring.charAt(i) == c){
                charword[i] = c;
                acertado = true;
            }
        }
        return acertado;
    }
}
