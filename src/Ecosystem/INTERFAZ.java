package Ecosystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.beancontext.BeanContextServiceProviderBeanInfo;

public class INTERFAZ extends JFrame {


    static String seleccionado = "nothing";
    Container Panel_mapa;
    Container contenedor;
    JLabel[][] label;

    Ecosistem ecosistem;

    int timer = 1000;
    int time = 0;
    static int tics = 0;

    Timer anyos = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ponerJL(ecosistem);
            System.out.println("interfaz actualizada");
        }
    });

    public INTERFAZ(Ecosistem ecosistem) {

        this.ecosistem = ecosistem;
        new JFrame("mapa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        Panel_mapa = new Container();
        Panel_mapa.setSize(600, 600);

        label = new JLabel[ecosistem.territorio.length][ecosistem.territorio[0].length];
        Panel_mapa.setLayout(new GridLayout(ecosistem.territorio.length, ecosistem.territorio[0].length));
        setLocationRelativeTo(null);
        contenedor = new Container();
        add(contenedor, BorderLayout.CENTER);
        contenedor.setSize(200, 200);
        contenedor.setLocation(new Point(50, 0));
        contenedor.setBackground(Color.white);

        contenedor.add(Panel_mapa);
        losJL(ecosistem);
        setVisible(true);
        anyos.start();

    }

    public void ponerJL(Ecosistem ecosistem) {

        for (int i = 0; i < ecosistem.territorio.length - 1; i++) {
            for (int j = 0; j < ecosistem.territorio[0].length - 1; j++) {

                if (losAnimales(i, j, ecosistem)) {
                    System.out.println(i + "  " + j);
                } else UnJL(i, j, ecosistem);

            }
        }
    }

    public boolean losAnimales(int i, int j, Ecosistem ecosistemº) {

        for (int k = 0; k < ecosistem.wolves.size(); k++) {
            if (ecosistem.wolves.get(i).point.equals(new Point(i, j)))
                label[i][j].setBackground(new Color(200, 100, 0));
            return true;
        }

        for (int k = 0; k < ecosistem.rabits.size(); k++) {
            if (ecosistem.rabits.get(i).point.equals(new Point(i, j)))
                label[i][j].setBackground(new Color(200, 200, 0));
            return true;
        }

        return false;
    }


    public void CambiarColor(Point p, Color color) {
        this.label[p.x][p.y].setBackground(color);
    }

    public void PonerNumero(int numero, Point posicion) {
        this.label[posicion.x][posicion.y].setText(("" + numero));
    }



    public void losJL(Ecosistem ecosistem) {

        for (int i = 0; i < ecosistem.territorio.length - 1; i++) {
            for (int j = 0; j < ecosistem.territorio[0].length - 1; j++) {

                label[i][j] = new JLabel("");
                //label[i][j].setBounds(i * 20, j * 20, 20, 20);
                label[i][j].setOpaque(true);

                if (losAnimales(i, j, ecosistem)) {

                } else UnJL(i, j, ecosistem);

                Panel_mapa.add(label[i][j]);
            }
        }
    }

    public void UnJL(int i, int j, Ecosistem ecosistem) {

        if (ecosistem.territorio[i][j] instanceof Agua)
            label[i][j].setBackground(new Color(0, 0, 100));
        else if (ecosistem.territorio[i][j] instanceof Hierba)
            label[i][j].setBackground(new Color(101, 180, 32));
        else if (ecosistem.territorio[i][j] instanceof Arbol)
            label[i][j].setBackground(new Color(27, 126, 29));
        else if (ecosistem.territorio[i][j] instanceof Tierra)
            label[i][j].setBackground(new Color(150, 100, 50));
    }

}

