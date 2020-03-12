package Acurario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Algas {

    double consumoOxigeno;
    double oxigenoconsumido;
    double luz;
    double opacidad;
    Timer reproductionTime;
    int time;
    int vida;

    Algas(Algas alga){
        this.luz = alga.luz;
        this.opacidad = alga.opacidad;
        this.consumoOxigeno = alga.consumoOxigeno;
        this.vida = alga.vida;
        this.reproductionTime = alga.reproductionTime;
        //reproductionTime.start();
    }
    Algas(Agua agua){
        this.luz = agua.luz ;
        this.opacidad = agua.opacidad;
        this.consumoOxigeno = agua.oxigeno * 0.01;
        this.time = (int)((Acuario.LUZ - this.luz) * 100);

        reproductionTime = new Timer(this.time, actionEvent -> {
            this.Respirar(agua);
        });
        reproductionTime.start();

    }

    public void Respirar(Agua agua){
        agua.OxigenoACarbono(this.consumoOxigeno);
        System.out.println("respirando: " + consumoOxigeno);
        System.out.println( agua.getQuality());
    }


}

