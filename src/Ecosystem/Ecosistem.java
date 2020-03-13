package Ecosystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ecosistem {
Casilla[][] territorio;
List<Rabbit> rabits;
List<Wolf> wolves;
List<Point> hierbas;
Timer time = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        generatePlants();
        rabitReproduction();
        System.out.println("Cantidad de conejos: " + rabits.size());
    }
});

    Ecosistem(int sizex, int sizey) {
        this.territorio = new MapTransformer(new MapGenerator(sizex, sizey)).Transform();
        rabits = new ArrayList<>();
        wolves = new ArrayList<>();
        hierbas = new ArrayList<>();
        generatePlants();
        time.start();

    }
    public void rabitReproduction(){
        for (int i = 0; i < this.rabits.size() ; i++) {
            for (int j = 0; j <this.rabits.size() ; j++) {
                if (!this.rabits.get(i).equals(this.rabits.get(j))){
                    if (this.rabits.get(i).point.equals(this.rabits.get(j).point))
                        System.out.println("new animal");
                        addAnimal(new Rabbit(this.rabits.get(i) ,this.rabits.get(j)));
                        return;
                }
            }

        }
    }
    public void addAnimal(Animal animal){
        if (animal instanceof Rabbit){
            this.rabits.add((Rabbit)animal);
        }
        if (animal instanceof Wolf){
            this.wolves.add((Wolf)animal);
        }
    }
    public void removeAnimal(Animal animal){
        if (animal instanceof Rabbit){
            this.rabits.remove(animal);
        }
        if (animal instanceof Wolf){
            this.wolves.remove(animal);
        }
    }

    public int contarPlantas(){
        int cantplantas = 0;
        for (int i = 0; i < this.territorio.length; i++) {
            for (int j = 0; j < this.territorio[0].length; j++) {
                if (this.territorio[i][j] instanceof Hierba)
                    cantplantas++;
            }
        }
        return cantplantas;
    }
    public void deleteTree(Point p){
        if (this.territorio[p.x][p.y] instanceof Arbol){
            this.territorio[p.x][p.y] = new Tierra();
        }
    }
    public void deletePlant(Point p){
        if (this.territorio[p.x][p.y] instanceof Hierba){
            if (((Hierba)this.territorio[p.x][p.y]).live <= 0) {
                this.hierbas.remove(p);
                this.territorio[p.x][p.y] = new Tierra();
            } else {
                ((Hierba)this.territorio[p.x][p.y]).live -= 0.2;
            }
        }
    }

    public void generatePlants(){
        int cont = 0;

        while (this.hierbas.size() <= 20 || cont < 2) {
            int randX = (int) (Math.random() * this.territorio.length);
            int randY = (int) (Math.random() * this.territorio[0].length);

            if (this.territorio[randX][randY] instanceof Tierra){
                this.territorio[randX][randY] = new Hierba();
                this.hierbas.add(new Point(randX, randY));
                cont++;
            }
        }
    }

}

class Casilla{}
class Tierra extends Casilla{}
class Agua extends Casilla{}
class Hierba extends Casilla{
    float live = 1;
}
class Arbol extends Casilla{}