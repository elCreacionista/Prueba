import animales.Noise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Noseque extends JFrame {


    int[][] que;
    JPanel panel = new JPanel();
    JLabel[][] mapa;

    public static void main(String[] args) {
        new Noseque(100,100);
    }
    Noseque(int height, int width){
        new JFrame("ola");
        setTitle("El Automata Celular de la grass");
        setSize(width * 5,height * 5);
        //setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridLayout(width,height));
        crearMapa(height, width);
        actualizarMapa();
        setVisible(true);
        Timer p = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                que = actualizacion();
                actualizarMapa();


            }
        });
        p.start();

    }


    public int[][] actualizacion(){
        int[][] que2 = new int[que.length][que[0].length];

        for (int i = 0; i <que2.length ; i++) {
            for (int j = 0; j < que2[0].length; j++) {
                que2[i][j] = que[i][j];

            }
        }
        for (int i = 0; i <que2.length ; i++) {
            for (int j = 0; j < que2[0].length; j++) {
                if (que[i][j] == 1) {
                    if (i != 0 && i != que.length - 1 && j != 0 && j != que[0].length - 1) {
                        int x = (int) (Math.random() * 3) - 1;
                        int y = (int) (Math.random() * 3) - 1;
                        if (que[i + x][j + y] != 2) {

                            que2[i + x][j + y] = 1;
                            que2[i][j] = 1;
                        }
                    }
                }
                if (que[i][j] == 2) {
                    if (i != 0 && i != que.length - 1 && j != 0 && j != que[0].length - 1) {


                        if (que[i-1][j-1] == 0 && que[i-1][j] == 0 &&que[i][j-1]==0 && que[i-1][j+1]==0 && que[i+1][j-1] == 0 &&que[i+1][j] == 0 && que[i][j+1] ==0){
                            que2[i][j] = 0;
                        }

                        int cont = 0;
                        if (que[i+1][j] == 1){
                            que2[i+1][j] = 2;
                            cont ++;
                        }else que2[i+1][j] = 0;

                        if (que[i+1][j-1] == 1){
                            que2[i+1][j-1] = 2;
                            cont ++;
                        }else que2[i+1][j-1] = 0;

                        if (que[i+1][j+1] == 1){
                            que2[i+1][j+1] = 2;
                            cont ++;
                        }else que2[i+1][j+1] = 0;

                        if (que[i-1][j] == 1){
                            que2[i-1][j] = 2;
                            cont ++;
                        }else que2[i-1][j] = 0;

                        if (que[i-1][j+1] == 1){
                            que2[i-1][j+1] = 2;
                            cont ++;
                        }else que2[i-1][j+1] = 0;

                        if (que[i-1][j-1] == 1){
                            que2[i-1][j-1] = 2;
                            cont ++;
                        }else que2[i-1][j-1] = 0;

                        if (que[i][j+1] == 1){
                            que2[i][j+1] = 2;
                            cont ++;
                        }else que2[i][j+1] = 0;

                        if (que[i][j-1] == 1){
                            que2[i][j-1] = 2;
                            cont ++;
                        }else que2[i][j-1] = 0;

                        if (cont > 2){
                            que2[i][j] = 2;
                        }
                    }
                }
                if (i == 0 || i == que.length - 1 || j == 0 || j == que[0].length - 1){
                    if (que2[i][j] == 2){
                        que2[i][j] = 0;
                    }
                }
            }
        }

        return que2;
    }


    public void crearMapa(int height, int width){
        mapa = new JLabel[width][height];
        que = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height ; j++) {
                que[i][j] = (int)(Math.random()*3);
                System.out.println(que[i][j]);
                mapa[i][j] = new JLabel();
                mapa[i][j].setOpaque(true);
                panel.add(mapa[i][j]);
            }
        }
    }

    public void actualizarMapa(){
        for (int i = 0; i <que.length ; i++) {
            for (int j = 0; j <que[i].length ; j++) {
                switch (que[i][j]){
                    case 0: mapa[i][j].setBackground(new Color(0,0,0));break;
                    case 1: mapa[i][j].setBackground(new Color(0,200,0));break;
                    case 2: mapa[i][j].setBackground(new Color(200,0,0));break;
                }
            }
        }


    }





}
