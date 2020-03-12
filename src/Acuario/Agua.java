package Acuario;

import java.util.ArrayList;
import java.util.List;

public class Agua {


    double luz;
    double oxigeno;
    double carbono;
    double nitritos;
    double opacidad;
    int posx;
    List<Algas> algasList;

    Agua(){}
    Agua(int altura){
        this.posx = altura;
        this.opacidad =altura*1.5;
        this.luz = Acuario.LUZ - opacidad;
        this.oxigeno = 70;
        this.carbono = 30;
        this.nitritos = 0;
        algasList = new ArrayList<Algas>();

    }



    public void OxigenoACarbono(double cantidad){
        if (this.oxigeno >= cantidad){
            this.oxigeno -= cantidad;
            this.carbono += cantidad;
        }
        else {
            System.out.println("No hay oxigeno amigo");
        }
    }
    public void CarbonoAOxigeno(double cantidad){
        if (this.carbono >= cantidad){
            this.carbono -= cantidad;
            this.oxigeno += cantidad;
        }
        else {
            System.out.println("No hay oxigeno amigo");
        }
    }


    public void actualizeBlock(Acuario acuario){
        this.opacidad =this.posx*1.5;
        this.luz = Acuario.LUZ - opacidad;

    }


    public Agua getAgua(){
        return this;
    }

    public String getQuality(){
        return "Opacity: " + opacidad + " Luz: " + luz + "\n" + "O:" + oxigeno + "%  C:" + carbono + "%";
    }

    public String getString(){
        return "Agua";
    }
}
