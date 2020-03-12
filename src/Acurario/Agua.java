package Acurario;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Agua {


    boolean raices = false;
    boolean solido = false;

    double luz;
    double oxigeno;
    double carbono;
    double nitritos;
    double opacidad;
    int posx;
    List<Algas> algasList;


    Agua(Acuario acuario, int i){
        actualizeBlock(acuario, i);

    }
    Agua(Agua agua){
        this.posx = agua.posx;
        this.algasList = agua.algasList;
        this.oxigeno = agua.oxigeno;
        this.carbono = agua.carbono;
        this.opacidad = agua.opacidad;
        this.luz = agua.luz;
        this.nitritos = agua.nitritos;

    }
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


    public void actualizeBlock(Acuario acuario, int posx){
        this.posx = posx;
        this.opacidad = this.posx*1.5;
        this.luz = Acuario.LUZ - opacidad;

    }


    public Agua getAgua(){
        return this;
    }

    public String getQuality(){
        return" x: " + posx +  "\nOpacity: " + opacidad + " Luz: " + luz + "\n" + "O:" + oxigeno + "%  C:" + carbono + "%";
    }

    public String getString(){
        return "Agua";
    }
}
