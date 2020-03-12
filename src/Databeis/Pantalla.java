package Databeis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Pantalla extends JFrame {

    public static boolean conectado = false;
    public static String queoperacion = "inicio";

    JPanel p_botones = new JPanel();
    JPanel p_respuestas = new JPanel();

    JButton conectar = new JButton();
    JButton[] operaciones, consultas, inserciones, eliminar, actualizar;

    JButton[] tables;
    JLabel conexion = new JLabel();
    JLabel operacion = new JLabel();
    JLabel[] teibol;


    String[][][] tablabase;
    String[][] tablabase1;
    String[] tablabase2;


    String[] nombretablas;
    String[] tablabase2_2;
    

    JButton delete = new JButton();


    Pantalla(Database p) throws Exception {
        new JFrame("DATABASE");
        setSize(1000,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        add(p_botones);add(p_respuestas);
        crearComportamientoBotones(p);
        PrimerBoton(p);
        crearJPRespuestas(p);
        p_respuestas.add(conexion);
        p_respuestas.add(operacion);
        setVisible(true);
    }
    public void crearJPRespuestas(Database p){
        p_respuestas.setBackground(Color.LIGHT_GRAY);
        p_respuestas.setLayout(new GridLayout(10,2, 10,10));
        ActualizarConexion();
        ActualizarOperacion();

    }
    public void ActualizarConexion(){
        if (conectado)conexion.setText("Conectado a la base de datos.");
        else conexion.setText("Desconectado de la base de datos.");
    }
    public void ActualizarOperacion(){
        operacion.setText("Estas en " + queoperacion);

    }

    public void crearJPBotones(Database p){
        p_botones.setLayout(new GridLayout(3,2, 10,10));
        p_botones.setBackground(Color.DARK_GRAY);
        setJBOperaciones(p);
    }
    public void crearComportamientoBotones(Database p) throws Exception {
        conectar.addActionListener(actionEvent -> {
            if (!conectado) {
                try {
                    p.CrearConexion();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                conectado = true;
                p_botones.removeAll();
                crearJPBotones(p);
                ActualizarConexion();
                PrimerBoton(p);
                p_botones.add(delete);

            }
            else{
                try {
                    p.Desconectar();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conectado = false;
                PrimerBoton(p);
                ActualizarConexion();
            }

        });

        operaciones = new JButton[5];
        for (int i = 0; i < operaciones.length ; i++) {
            operaciones[i] = new JButton();
            operaciones[i].setBackground(Color.GRAY);
        }


        delete.setText("DELETE");
        delete.addActionListener(actionEvent -> {
            System.out.println("drop");
            try {
                p.drop();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ActualizarOperacion();
            AddJBTables(p);
            p_botones.remove(delete);
        });

        operaciones[0].setText("CONSULTAR");
        operaciones[0].addActionListener(actionEvent -> {
            System.out.println("hola");
            queoperacion = "consultar";
            ActualizarOperacion();


            AddJBTables(p);
        });
        operaciones[1].setText("INSERTAR");
        operaciones[1].addActionListener(actionEvent -> {
            System.out.println("inserta");
            queoperacion = "insertar";
            ActualizarOperacion();
            AddJBTables(p);
        });
        operaciones[2].setText("ELIMINAR");
        operaciones[2].addActionListener(actionEvent -> {
            System.out.println("elimina");
            queoperacion = "eliminar";
            ActualizarOperacion();
            AddJBTables(p);
        });
        operaciones[3].setText("ACTUALIZAR");
        operaciones[3].addActionListener(actionEvent -> {
            System.out.println("actualiza");
            queoperacion = "actualizar";
            ActualizarOperacion();
            AddJBTables(p);
        });
        operaciones[4].setText("VOLVER");
        operaciones[4].addActionListener(actionEvent -> {
            System.out.println("inicio");
            queoperacion = "inicio";
            ActualizarOperacion();
            PrimerBoton(p);
        });

        String[] tablas = p.Preguntar("show tables","tables_in_"+ p.namedatabase);
        tables = new JButton[tablas.length];
        tablabase = new String[tablas.length][][];

        for (int i = 0; i < tables.length ; i++) {
            tables[i] = new JButton();
            tables[i].setText(tablas[i]);
            tables[i].setBackground(Color.GRAY);

            tablabase[i] = p.Preguntar("SHOW COLUMNS FROM " + tablas[i], new String[]{"Field", "Type"});

            tables[i].addActionListener(e -> {
                String text = e.getActionCommand();
                System.out.println("Te has metido en" + text);
                int num = 0;
                    for (int j = 0; j < tablas.length ; j++) {
                        num = j;
                        if (tablas[j].equals(text)) break;
                    }
                    System.out.println(e.getSource());

                    tablabase2 = new String[tablabase[num].length];
                    tablabase2_2 = new String[tablabase[num].length];

                    for (int j = 0; j <tablabase2.length ; j++) {
                        tablabase2[j] = tablabase[num][j][0];
                        tablabase2_2[j] = tablabase[num][j][1];

                        System.out.println(tablabase2[j]);
                    }

                    try {
                        tablabase1 = p.Preguntar("select * from " + text, tablabase2);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                setJLTablas(p,tablabase1);
                consultas = new JButton[tablabase2.length];
                p_botones.removeAll();
                p_botones.setLayout(new GridLayout(1,consultas.length   ,10,10));
                for (int j = 0; j < consultas.length ; j++) {
                    consultas[j] = new JButton();
                    consultas[j].setText(tablabase2[j]);
                    consultas[j].setBackground(Color.GRAY);
                    consultas[j].addActionListener(action -> {

                        System.out.println("holaaaa");
                        /*try {
                            AddJBConsultas(p,action.getActionCommand(),new String[]{"*"});
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }*/

                    });
                    try {
                        AddJBConsultas(p);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }



            });
        }
        for (int i = 0; i <tablabase.length ; i++) {
            for (int j = 0; j < tablabase[i].length ; j++) {
                for (int k = 0; k < tablabase[i][j].length ; k++) {

                    System.out.print( i + " " + j + " " + k + " is " + tablabase[i][j][k] + "  ");
                }
                System.out.println("");
            }
        }

    }
    public void AddJBConsultas(Database p/*, String tabla, String[] column*/) throws Exception {

        setVisible(false);

        for (int i = 0; i < consultas.length; i++) {
            p_botones.add(consultas[i]);
        }


        /*p_botones.removeAll();
        StringBuilder laconsulta = new StringBuilder();
        for (int i = 0; i <column.length ; i++) {
            laconsulta.append(column[i]);
            if (i != column.length - 1)
                laconsulta.append(", ");
        }
        nombretablas = p.Preguntar("select "+ laconsulta.toString() + " from ", tabla );
        for (int i = 0; i <consultas.length ; i++) {

            p_botones.add(consultas[i]);
        }
*/
        setVisible(true);
    }

    public void setJLTablas(Database p, String[][] tablaX){
        setVisible(false);
        p_respuestas.removeAll();
        int tamanio = tablaX.length % 10;
        if (tamanio == 0)tamanio = 1;
        p_respuestas.setLayout(new GridLayout(7, tamanio,10,10));

        teibol = new JLabel[tablaX.length];
        for (int i = 0; i <tablaX.length ; i++) {
            StringBuilder nombre = new StringBuilder();
            for (int j = 0; j <tablaX[i].length ; j++) {
                nombre.append(tablaX[i][j]).append(" ");
            }
            teibol[i] = new JLabel(String.valueOf(nombre));
            p_respuestas.add(teibol[i]);
        }
        setVisible(true);
    }

    public void AddJBTables(Database p){
        setVisible(false);
        p_botones.removeAll();
        for (int i = 0; i < tables.length ; i++) {
            p_botones.add(tables[i]);
        }

        PrimerBoton(p);
        setVisible(true);
    }



    public void PrimerBoton(Database p){
        setVisible(false);
        if (conectado){
            p_botones.remove(conectar);
            p_botones.add(conectar);
            conectar.setText("DESCONECTAR");
        }
        else {
            p_botones.removeAll();
            p_botones.add(conectar);
            conectar.setText("CONECTAR");
            p_botones.setLayout(new GridLayout(1,1, 10,10));
        }
        conectar.setBackground(Color.white);
        setVisible(true);
    }

    public void setJBOperaciones(Database p){
        setVisible(false);
        p_botones.removeAll();
        for (int i = 0; i < operaciones.length ; i++) {
            p_botones.add(operaciones[i]);
        }
        setVisible(true);
    }

}


/*
class Tabla{

    public static String[] getVariables(String[] type){
        String [] repsuesta = new String[type.length];
        int j = 0;
        for (int i = 0; i < type.length ; i++) {
            char[] palabros = type[i].toCharArray();
            boolean tipofound = false;

            while (!tipofound) {
                if (palabros[j] == 'v' && palabros[j+1] == 'a' && palabros[j+2] == 'r'|| palabros[j] == 'c' && palabros[j+1] == 'h' && palabros[j+2] == 'a' && palabros[j+3] == 'r'){
                    repsuesta[i] = "String";
                    tipofound = true;
                }
                else if (palabros[j] == 'i' && palabros[j+1] == 'n' && palabros[j+2] == 't'){
                    repsuesta[i] = "int";
                    tipofound = true;
                }

                    j++;
            }
        }
        return repsuesta;
    }*/