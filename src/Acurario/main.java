package Acurario;

import javax.swing.*;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.awt.*;
import java.awt.event.*;

public class main {


    public static void main(String[] args) {
        Acuario acuario = new Acuario(100,200);


        new ELpanel(acuario);
    }
}

enum block {
    SUBSTRATO(0),
    ARENA(1),
    ROCA(2),
    AGUA(3);

    public static block getEnum(int n){
        block block;
        switch (n){
            case 0: block = Acurario.block.SUBSTRATO;break;
            case 1: block = Acurario.block.ARENA;break;
            case 2: block = Acurario.block.ROCA;break;
            case 3: block = Acurario.block.AGUA;break;
            default: block = Acurario.block.AGUA;break;
        }
        return block;
    }

    public static String getString(block block){
        switch (block){
            case SUBSTRATO: return "Substrato";
            case ARENA: return "Arena";
            case ROCA: return "Roca";
            case AGUA: return "Agua";

            default: return "Error";
        }

    }

    int valor;
    block(int num){
        this.valor = num;
    }
}
class ELpanel extends JFrame{

    int framex;
    int framey;
    block block = Acurario.block.SUBSTRATO;

    JPanel statics;
    JPanel main;
    JLabel[][] mapa;
    Timer actualizarAcuario;
    ELpanel(Acuario acuario) {
        new JFrame("ola");
        framex = acuario.aguas.length * 6;
        framey = acuario.aguas[0].length * 6;
        setSize(framey, framex);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        main = new JPanel();
        main.setSize(framey,framex);
        add(main);

        main.setLayout(new GridLayout(acuario.aguas.length, acuario.aguas[0].length));
        main.setBackground(Color.LIGHT_GRAY);
        crearMapa(acuario);
        actualizarMapa(acuario);
        setVisible(true);
        actualizarAcuario = new Timer(100,actionEvent -> {
            acuario.Caer();
           actualizarMapa(acuario);
        });
        actualizarAcuario.start();
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
                int num = (int)(Math.random()*4);
                block = Acurario.block.getEnum(num);
                System.out.println("Utilizas: " + Acurario.block.getString(block));
            }
        });
        main.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                switch (block){
                    case SUBSTRATO:
                        acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)] =
                                new Substrato(e.getY() / (framex / acuario.aguas.length),
                                        e.getX() / (framey / acuario.aguas[0].length),
                                        acuario, acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)]);
                        break;
                    case ARENA:
                        acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)] =
                                new Arena(e.getY() / (framex / acuario.aguas.length),
                                        e.getX() / (framey / acuario.aguas[0].length),
                                        acuario, acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)]);
                        break;
                    case ROCA:
                        acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)] =
                                new Roca(e.getY() / (framex / acuario.aguas.length),
                                        e.getX() / (framey / acuario.aguas[0].length),
                                        acuario, acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)]);
                        break;
                    case AGUA:
                        acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)] =
                                new Agua(acuario.aguas[e.getY() / (framex / acuario.aguas.length)][e.getX() / (framey / acuario.aguas[0].length)].getAgua());
                    break;
                }


            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
        main.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println(acuario.aguas[e.getY()/(framex/acuario.aguas.length)][e.getX()/(framey/acuario.aguas[0].length)].getQuality());

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public void crearMapa(Acuario acuario){
        mapa = new JLabel[acuario.aguas.length][acuario.aguas[0].length];
        for (int i = 0; i < mapa.length ; i++) {
            for (int j = 0; j < mapa[0].length ; j++) {
                mapa[i][j] = new JLabel();
                mapa[i][j].setOpaque(true);
                main.add(mapa[i][j]);
            }
        }
    }




    public void actualizarMapa(Acuario acuario){
        for (int i = 0; i <mapa.length ; i++) {
            for (int j = 0; j <mapa[0].length ; j++) {
                switch (acuario.aguas[i][j].getString()){
                    case "Agua": mapa[i][j].setBackground(setColor(acuario, i, j));break;
                    case "Substrato":
                        if (acuario.aguas[i][j].solido){
                            mapa[i][j].setBackground(new Color(100,70,0));
                        } else{
                            mapa[i][j].setBackground(new Color(150,100,0));
                        }
                        break;
                    default: mapa[i][j].setBackground(Color.RED);break;

                    case "Arena": mapa[i][j].setBackground(new Color(240,200,0));break;

                    case "Roca": mapa[i][j].setBackground(new Color(150,150,150));break;

                }
            }
        }
    }

    public Color setColor(Acuario acuario, int x, int y){
        int blue;
        blue = (int)(acuario.aguas[x][y].luz * (255 / Acuario.LUZ) + Acuario.LUZ * 6);
        if (blue < 0) blue = 0;
        if (blue > 255) blue = 255;
        return new Color(0,0,blue);

    }

}
