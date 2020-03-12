package Ecosystem;

import java.awt.*;

public class Rabbit extends Animal{
    Rabbit(Point point) {
        super(point);
    }

    Rabbit(Animal animal1, Animal animal2) {
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

        return new Rabbit(this, animal);

    }
}
