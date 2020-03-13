package Ecosystem;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        Ecosistem eco = new Ecosistem(50,50);
        for (int i = 0; i < 10 ; i++) {
            eco.addAnimal(new Rabbit(eco));
        }

        new INTERFAZ(eco);
    }
}
