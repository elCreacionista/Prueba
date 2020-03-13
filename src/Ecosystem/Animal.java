package Ecosystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public abstract class Animal {
    Point point;

    float hunger;
    float thirst;
    float reproduceurgue;

    boolean drinking = false;
    boolean eating = false;

    float[] adn;

    float indexhunger; //0
    float indexthrist; //1
    float indexreproductiontime; //2
    float vista; //3

    boolean male, female;
    Ecosistem ecosistem;


    Timer life = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            passTime();
            move();
            eat();
            drink();
        }
    });

    Animal(Ecosistem ecosistem){
        int randX = (int)(Math.random() * ecosistem.territorio.length);
        int randY = (int)(Math.random() * ecosistem.territorio[0].length);
        while (!(ecosistem.territorio[randX][randY] instanceof Tierra)){
            randX = (int)(Math.random() * ecosistem.territorio.length);
            randY = (int)(Math.random() * ecosistem.territorio[0].length);
        }
        this.point = new Point(randX, randY);
        this.ecosistem = ecosistem;
        this.hunger = 0;
        this.thirst = 0;
        this.reproduceurgue = 0;
        this.adn = generateRandomAdn();
        mutate();
        setStatics();
        this.life.start();
    }
    Animal(Animal animal1, Animal animal2){
        this.ecosistem = animal1.ecosistem;
        this.point = animal1.point;
        this.hunger = 0;
        this.thirst = 0;
        this.reproduceurgue = 0;
        this.adn = combinateAdn(animal1, animal2);
        mutate();
        setStatics();
        this.life.start();
    }


    public float[] combinateAdn(Animal animal1, Animal animal2){
        float[] adn = new float[animal1.adn.length];
        for (int i = 0; i < adn.length; i++) {
            if (animal1.adn[i] != animal2.adn[i]){
                switch ((int)(Math.random()*2)){
                    case 0: adn[i] = animal1.adn[i];break;
                    case 1: adn[i] = animal2.adn[i];break;
                }
                if (adn[i] > 1){
                    adn[i] = 1;
                }
            } else {
                adn[i] = animal1.adn[i];
            }
        }
        return adn;
    }

    public void setStatics(){
        this.indexhunger = this.adn[0];
        this.indexthrist = this.adn[1];
        this.indexreproductiontime = this.adn[2];
        this.vista = this.adn[3];
        switch ((int)(Math.random()*2)){
            case 0: this.male = true; this.female = false; break;
            case 1: this.male = false; this.female = true; break;
        }
    }


    public void mutate(){
        if ((int)(Math.random()*10) == 0)
        for (int i = (int)(Math.random()*this.adn.length) ; i < this.adn.length ; i++)
            adn[i] += (Math.random()*0.1) - 0.05;
    }

    public void passTime(){
        this.hunger += indexhunger;
        this.thirst += indexthrist;
        this.reproduceurgue += indexreproductiontime;
        if (hunger >= 1 || thirst >= 1 || ecosistem.territorio[this.point.x][this.point.y] instanceof Agua) {
            life.stop();
            ecosistem.removeAnimal(this);
        }
    }
    public abstract void move();
    public abstract void eat();
    public abstract void drink();

    Point searchWater(){
        Map<Integer,Point> distancias = new HashMap<>();

        int x = this.point.x - 4;
        if (this.point.x < 4)
            x = 0;
        if (this.point.x > ecosistem.territorio.length - 4)
            x = ecosistem.territorio.length - 9;
        int y = this.point.y - 4;
        if (this.point.y < 4)
            y = 0;
        if (this.point.x > ecosistem.territorio[0].length - 4)
            y = ecosistem.territorio[0].length - 9;

        for (int i = x; i < x + 9 ; i++) {
            for (int j = y; j < y + 9; j++) {
                if (ecosistem.territorio[i][j] instanceof Agua){
                    distancias.put(getDistancia(this.point, new Point(i,j)), new Point(i,j));
                }
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (distancias.containsKey(i))
                return distancias.get(i);
        }
        return this.point;
    }

    public abstract Animal reproduce(Animal animal);
    public float[] generateRandomAdn(){
        return new float[]{(float) (Math.random()*0.1), (float) (Math.random()*0.1), (float) (Math.random()*0.1),(float) (Math.random()*0.1)};
    }
    public int getDistancia(Point inicio, Point destino){
        int distancia = 0;
        if (inicio.equals(destino))
            return 0;

        if (destino.x < inicio.x )
            distancia += inicio.x - destino.x;
        else
            distancia += destino.x - inicio.x;

        if (destino.y < inicio.y )
            distancia += inicio.y - destino.y;
        else
            distancia += destino.y - inicio.y;

        return distancia;
    }

    public Point goTo(Point objetive){
        if (getDistancia(this.point, objetive) == 1)
            return this.point;
        Point camino = this.point;
        while (getDistancia(camino, objetive) > 1) {
            if (ecosistem.territorio[this.point.x + 1][this.point.y] instanceof Tierra && getDistancia(new Point(this.point.x + 1, this.point.y), objetive) < getDistancia(new Point(this.point.x, this.point.y), objetive))
                return new Point(this.point.x + 1, this.point.y);

            if (ecosistem.territorio[this.point.x - 1][this.point.y] instanceof Tierra && getDistancia(new Point(this.point.x - 1, this.point.y), objetive) < getDistancia(new Point(this.point.x, this.point.y), objetive))
                return new Point(this.point.x - 1, this.point.y);

            if (ecosistem.territorio[this.point.x][this.point.y + 1] instanceof Tierra && getDistancia(new Point(this.point.x, this.point.y + 1), objetive) < getDistancia(new Point(this.point.x, this.point.y), objetive))
                return new Point(this.point.x, this.point.y + 1);

            if (ecosistem.territorio[this.point.x][this.point.y - 1] instanceof Tierra && getDistancia(new Point(this.point.x, this.point.y - 1), objetive) < getDistancia(new Point(this.point.x, this.point.y), objetive))
                return new Point(this.point.x, this.point.y - 1);


            if (ecosistem.territorio[this.point.x + 1][this.point.y] instanceof Tierra)
                return new Point(this.point.x + 1, this.point.y);

            if (ecosistem.territorio[this.point.x - 1][this.point.y] instanceof Tierra)
                return new Point(this.point.x - 1, this.point.y);

            if (ecosistem.territorio[this.point.x][this.point.y + 1] instanceof Tierra)
                return new Point(this.point.x, this.point.y + 1);

            if (ecosistem.territorio[this.point.x][this.point.y - 1] instanceof Tierra)
                return new Point(this.point.x, this.point.y - 1);

        }
        return this.point;
    }


}
