package Ecosystem;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        Ecosistem eco = new Ecosistem(30,30);
        for (int i = 0; i < 100 ; i++) {
            eco.addAnimal(new Rabbit(eco));
        }

        new INTERFAZ(eco);
    }
}
