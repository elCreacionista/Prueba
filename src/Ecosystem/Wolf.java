package Ecosystem;

import java.awt.*;

public class Wolf extends Animal{


    Wolf(Ecosistem ecosistem) {
        super(ecosistem);
    }

    Wolf(Animal animal1, Animal animal2) {
        super(animal1, animal2);
    }


    @Override
    public void passTime(){
        super.passTime();
    }

    @Override
    public void move() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void drink() {

    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Wolf(this, animal);
    }
}
