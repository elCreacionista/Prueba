package Ecosystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ecosistem {
Casilla[][] territorio;
List<Rabbit> rabits;
List<Wolf> wolves;
Timer time = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        generatePlants();
        System.out.println("Ecosistem actualizado");
    }
});

    Ecosistem(int sizex, int sizey) {
        this.territorio = new MapTransformer(new MapGenerator(sizex, sizey)).Transform();
        rabits = new ArrayList<>();
        wolves = new ArrayList<>();
        time.start();

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

    public void generatePlants(){
        int cont = 0;

        while (contarPlantas() <= 20 || cont < 2) {
            int randX = (int) (Math.random() * this.territorio.length);
            int randY = (int) (Math.random() * this.territorio[0].length);

            if (this.territorio[randX][randY] instanceof Tierra){
                this.territorio[randX][randY] = new Hierba();
                cont++;
            }
        }
    }

}

class Casilla{}
class Tierra extends Casilla{}
class Agua extends Casilla{}
class Hierba extends Casilla{}
class Arbol extends Casilla{}