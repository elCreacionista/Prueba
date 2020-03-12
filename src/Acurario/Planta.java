package Acurario;

import java.util.List;

public class Planta {

    double energia;
    double vida;
    double luznecesaria;
    double luzactual;
    double consumoC;



    Semilla semilla;
    Tajo[] tajos;
    List<Hoja> hojas;
    List<Raiz> raices;
}
class Semilla {
    int posx;
    int posy;
}
class Tajo extends Semilla{

}
class Hoja extends Semilla{

}
class Raiz extends Semilla{

}