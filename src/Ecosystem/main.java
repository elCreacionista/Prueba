package Ecosystem;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        Ecosistem eco = new Ecosistem(40,40);
        eco.addAnimal(new Rabbit(new Point(15,15), eco));
        eco.addAnimal(new Rabbit(new Point(16,1), eco));
        eco.addAnimal(new Rabbit(new Point(17,20), eco));
        eco.addAnimal(new Rabbit(new Point(3,35), eco));
        eco.addAnimal(new Rabbit(new Point(9,1), eco));

        new INTERFAZ(eco);
    }
}
