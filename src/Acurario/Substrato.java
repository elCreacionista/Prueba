package Acurario;

public class Substrato extends Agua{

    double recursos;


    Agua agua;
    int posx;
    int posy;



    Substrato(int posx, int posy, Acuario acuario, Agua agua){
        super();
        this.agua = agua;
        this.posx = posx;
        this.posy = posy;
        this.recursos = 50;
        this.nitritos = 0;
        actualizeBlock(acuario, posx);
        acuario.aguas[posx][posy] = this;
    }







    @Override
    public void actualizeBlock(Acuario acuario, int posx){

        this.posx = posx;

        if (posx >= 1) {
            if (!acuario.aguas[posx - 1][posy].getString().equals("Agua")) {
                this.opacidad = 200;
                this.luz = acuario.aguas[posx - 1][posy].luz - opacidad;
            }
            else {
                this.opacidad =posx*1.5;
                this.luz = Acuario.LUZ - opacidad;
            }
        }
        else{
            this.opacidad =posx*1.5;
            this.luz = Acuario.LUZ - opacidad;
        }
    }


    @Override
    public Agua getAgua() {
        return this.agua;
    }

    @Override
    public String getQuality(){
        return "Opacity: " + opacidad + " Recursos: " + recursos + " Luz: " + luz + "\n" + "O:" + oxigeno + "%  C:" + carbono + "%";
    }

    @Override
    public String getString(){
        return "Substrato";
    }
}
