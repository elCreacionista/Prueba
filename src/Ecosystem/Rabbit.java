package Ecosystem;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Rabbit extends Animal{
    Rabbit(Ecosistem ecosistem) {
        super(ecosistem);
    }

    Rabbit(Animal animal1, Animal animal2) {
        super(animal1, animal2);
    }

    @Override
    public void passTime(){
        super.passTime();
    }

    private Point searchFood(){
        Map<Integer,Point> distancias = new HashMap<>();
        for (int i = 0; i < ecosistem.hierbas.size(); i++) {
                distancias.put(getDistancia(this.point, ecosistem.hierbas.get(i)), ecosistem.hierbas.get(i));
        }
        for (int i = 1; i < 1000 ; i++) {
            if (distancias.containsKey(i))
                return distancias.get(i);
        }
        return this.point;
    }


    @Override
    public void move() {
        if (hunger > thirst)
        this.point = goTo(searchFood());
        else
            this.point = goTo(searchWater());

    }

    @Override
    public void eat() {
        if (getDistancia(searchFood(),this.point) == 1 && this.hunger > 0){
            this.hunger -= 0.2;
            ecosistem.deletePlant(searchFood());
        }
    }

    @Override
    public void drink() {

            if (ecosistem.territorio[this.point.x - 1][this.point.y] instanceof Agua) {
                this.thirst -= 0.2;
                return;
            }
            if (ecosistem.territorio[this.point.x + 1][this.point.y] instanceof Agua) {
                this.thirst -= 0.2;
                return;
            }
            if (ecosistem.territorio[this.point.x][this.point.y + 1] instanceof Agua) {
                this.thirst -= 0.2;
                return;
            }
            if (ecosistem.territorio[this.point.x][this.point.y - 1] instanceof Agua) {
                this.thirst -= 0.2;
            }
        }



    @Override
    public Animal reproduce(Animal animal) {
        return new Rabbit(this, animal);
    }


}
