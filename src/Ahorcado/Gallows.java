package Ahorcado;

public abstract class Gallows {

    int pointsLeft = 5;


    abstract void display();

    void addPart(){
        pointsLeft--;
    }
    boolean isHung(){
        return pointsLeft <= 0;
    }
}
