package Ahorcado;

public class HangMan {
    private WordFactory wf;
    private GameController gc;

    HangMan(WordFactory wf){
        this.wf = wf;
        Gallows g = new TextGallows();
        AlphabetDisplay ad = new TextAlphabetDisplay();
        WordDisplay wd = new TextWorldDisplay();
        gc = new GameController(ad,wd,g);
    }
    void play(){
        gc.playGame(this.wf.makeWord());
    }

}
