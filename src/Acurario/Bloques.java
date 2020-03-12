package Acurario;

public class Bloques{}
class Arena extends Substrato{


    Arena(int posx, int posy, Acuario acuario, Agua agua) {
        super(posx, posy, acuario, agua);
        this.recursos = 20;


        acuario.aguas[posx][posy] = this;
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
        return "Arena";
    }
}
class Roca extends Substrato{


    Roca(int posx, int posy, Acuario acuario, Agua agua) {
        super(posx, posy, acuario, agua);
        this.recursos = 0;
        this.solido = true;


        acuario.aguas[posx][posy] = this;
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
        return "Roca";
    }
}
