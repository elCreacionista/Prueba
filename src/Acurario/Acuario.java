package Acurario;

import java.util.List;

public class Acuario {

    public final static double LUZ = 60;
    public static int ALTURA;
    public static int LONGITUD;


    Agua[][] aguas;
    Depuradora depuradora;
    List<Peces> pecesList;
    List<Comida> comidaList;


    Acuario(int altura, int longitud) {
        ALTURA = altura;
        LONGITUD = longitud;
        aguas = new Agua[altura][longitud];

        for (int i = 0; i < aguas.length; i++) {
            for (int j = 0; j < aguas[0].length; j++) {
                aguas[i][j] = new Agua(i);

                if (i == aguas.length - 1)
                    aguas[i][j] = new Substrato(i,j,this,aguas[i][j]);

                if (i == aguas.length - 2)
                    aguas[i][j] = new Substrato(i,j,this,aguas[i][j]);

                if (i == aguas.length - 3 && (int)(Math.random()*3) == 0)
                    aguas[i][j] = new Substrato(i,j,this,aguas[i][j]);
            }
        }
    }


    public void Caer() {
        for (int i = aguas.length - 1; i >= 0; i--) {
            for (int j = aguas[0].length - 1; j >= 0; j--) {



                if (aguas[i][j].getString().equals("Roca"))

                    if (i < aguas.length - 1)
                    if (aguas[i + 1][j].getString().equals("Agua")|| (int)(Math.random()*3) == 0)
                            if (!aguas[i + 1][j].solido) {
                                Agua ayuda = aguas[i + 1][j];
                                aguas[i + 1][j] = aguas[i][j];
                                aguas[i][j] = ayuda;

                            }





                if (!aguas[i][j].solido && (aguas[i][j].getString().equals("Substrato") || aguas[i][j].getString().equals("Arena"))) {
                    if (i < aguas.length - 1)
                        if (aguas[i + 1][j].getString().equals("Agua")) {
                            Agua ayuda = aguas[i + 1][j];
                            aguas[i + 1][j] = aguas[i][j];
                            aguas[i + 1][j].posx--;
                            aguas[i][j] = ayuda;
                            aguas[i][j].posx++;

                        }

                    int rand = (int) (Math.random() * 2);
                    if (i > 0)
                        if (aguas[i - 1][j].getString().equals("Substrato") || aguas[i][j].getString().equals("Arena")) {
                            if (rand == 0)
                                if (j < aguas[0].length - 1)
                                    if (aguas[i][j + 1].getString().equals("Agua")) {

                                        Agua ayuda = aguas[i][j + 1];
                                        aguas[i][j + 1] = aguas[i][j];
                                        aguas[i][j] = ayuda;
                                    }
                            if (rand == 1)
                                if (j > 0)
                                    if (aguas[i][j - 1].getString().equals("Agua")) {

                                        Agua ayuda = aguas[i][j - 1];
                                        aguas[i][j - 1] = aguas[i][j];
                                        aguas[i][j] = ayuda;
                                    }

                        }

                    if (aguas[i][j].getString().equals("Substrato") && aguas[i - 1][j].getString().equals("Substrato")) {

                        if ((int) (Math.random() * 100) * ((aguas.length - 1 ) - i) == 0) {
                            aguas[i][j].solido = true;

                        }

                    }
                }
                aguas[i][j].actualizeBlock(this, i);
            }

        }
    }
}
