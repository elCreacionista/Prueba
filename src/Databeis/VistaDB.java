package Databeis;

import javax.swing.*;
import java.awt.*;

public class VistaDB extends JFrame {




    JPanel p_botones = new JPanel();
    JPanel p_respuestas = new JPanel();

    JButton[][][] consultas;
    JButton[][][] inserts;
    JButton[][][] delete;
    JButton[][][] update;

    JLabel[][][] label_database;

    String[][][] string_DATABASE;

    VistaDB(){
        new JFrame("DATABASE");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        add(p_botones);add(p_respuestas);
        setVisible(true);
    }

}
