package Acuario;


import java.util.List;

public class Acuario {

    public final static double LUZ = 60;
    public static int ALTURA;
    public static int LONGITUD;


    Agua[][] aguas;
    /*Depuradora depuradora;
    List<Peces> pecesList;
    List<Comida> comidaList;
    */


    Acuario(int altura, int longitud){
        ALTURA = altura;
        LONGITUD = longitud;
        aguas = new Agua[altura][longitud];

        for (int i = 0; i < aguas.length ; i++) {
            for (int j = 0; j < aguas[0].length ; j++) {
                aguas[i][j] = new Agua(i);
            }
        }
    }

}
