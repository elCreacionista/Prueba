package Personal;

public class Herencia {


    public static void main(String[] args){

        Empleat pepito = new Empleat(3000);
        Empleat jesus = new Empleat(10000);
        jesus = new Encarregat(jesus);
        Empleat mikelestepario = new Empleat(1000);
        Encarregat sus = (Encarregat) jesus;

        mikelestepario = new Encarregat(mikelestepario);

        Esclau michaelJackson = new Esclau();
        michaelJackson.setSou(300);


        System.out.println(michaelJackson.getSou());
        sus.MandarCosas();
        System.out.println(jesus.getSou());
        pepito.SerMandado();
        System.out.println(pepito.getSou());
        mikelestepario.SerMandado();
        System.out.println(mikelestepario.getSou());
        jesus.SerMandado();
        System.out.println(jesus.getSou());



    }
}


class Empleat{
    double sou;
    Empleat(double sou){
        this.sou = sou;
    }
    public void setSou(double sou){
        this.sou = sou;
    }
    public double getSou(){
        return this.sou;
    }
    public void SerMandado(){
        System.out.println(this.toString() + ": okey jefe");
    }
    @Override
    public String toString(){
        return "Empleat";
    }

}
class Encarregat extends Empleat{
    Encarregat(double sou){
        super(sou);
    }

    Encarregat(Empleat t){
        super(t.sou * 1.1);
    }
    @Override
    public void setSou(double sou){
        this.sou = sou;
    }
    public double getSou(){
        return this.sou;
    }
    public void MandarCosas(){
        System.out.println(this.toString() + ": OYE NIÑO HAZ COSAS");
    }
    @Override
    public String toString(){
        return "Encarregat";
    }

}

class Esclau extends Empleat{

    public final double sou = 0;
    String trabajo = "infinito";
    Esclau(){
        super(0);
    }

    @Override
    public void setSou(double sou) {
        System.out.println("hola");
    }

    @Override
    public String toString(){
        return "Esclau";
    }

}























