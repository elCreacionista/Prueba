package Acuario;


import javax.swing.*;


public class main {

    public static void main(String[] args) {
        Acuario acuario = new Acuario(20,20);
        acuario.aguas[10][0].algasList.add(new Algas(acuario.aguas[10][0]));
        new setap();
    }
}



class setap extends JFrame{


    setap(){



    }

}


