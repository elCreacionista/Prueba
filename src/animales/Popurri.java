package animales;

import javax.swing.*;
import java.awt.*;

public class Popurri extends JFrame {
    public static void main(String[] args) {
        Popurri p = new Popurri();
        p.noise.printAsCSV();
    }


    Noise noise;

    JPanel panel = new JPanel();
    JLabel[][] main_map;


    Popurri(){
        new JFrame("hola");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.RED);
        //panel.setSize(400,400);
        main_map = new JLabel[100][100];
        panel.setLayout(new GridLayout(10,10,1,1));
        add(panel);
        crearnoise();

        setVisible(true);
    }

    public void crearnoise(){
        noise = new Noise(null,0.1f,100,100);
        noise.initialise();

        for (int i = 0; i < main_map.length ; i++) {
            for (int j = 0; j <main_map[0].length ; j++) {
                main_map[i][j] = new JLabel("p");
                main_map[i][j].setSize(10,10);
                main_map[i][j].setBackground(Color.BLUE);
                if (noise.grid_[i][j] > 0) {
                    main_map[i][j].setBackground(Color.GREEN);
                }
                if (noise.grid_[i][j] > 0.30) {
                    main_map[i][j].setBackground(Color.BLACK);
                }
                panel.add(main_map[i][j]);
            }
        }
    }
}
