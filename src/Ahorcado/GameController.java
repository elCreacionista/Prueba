package Ahorcado;

import java.util.Scanner;

public class GameController {

    private AlphabetDisplay ad;
    private Alphabet alphabet;
    private WordDisplay wd;
    private Gallows gallows;


    GameController(AlphabetDisplay ad, WordDisplay wd, Gallows g){
        this.ad = ad;
        this.wd = wd;
        this.gallows = g;
        alphabet = new Alphabet();
    }

    public void playGame(Word w){
        while (!w.idGuessed() && !gallows.isHung()) {
            this.gallows.display();
            this.wd.display(w);

            this.ad.display(this.alphabet);
            char c = this.getImput();
            if (!alphabet.doGuess(c) && !w.doGuess(c))
                gallows.addPart();
        }

        this.wd.display(w);
        if (w.idGuessed()) System.out.println("VICTORIA");
        else {
            this.gallows.display();
            System.out.println("DERROTA");
        }
    }
private char getImput(){
    Scanner scaner = new Scanner(System.in);
    String p = scaner.nextLine();
    return p.charAt(0);

}

}
