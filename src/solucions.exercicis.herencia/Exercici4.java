package solucions.exercicis.herencia;

public class Exercici4 {
    public static void main(String[] args) {
        Empleat john = new Empleat(1500);
        Empleat sarah = new Encarregat(1500);

        System.out.printf("Sou empleat: %.2f\n", john.getSou());
        System.out.printf("Sou encarregat: %.2f\n", sarah.getSou());
    }

    static class Empleat {
        private double souBase;

        Empleat(double souBase) {
            this.souBase = souBase;
        }

        public double getSou() {
            return this.souBase;
        }
    }

    static class Encarregat extends Empleat {

        Encarregat(double souBase) {
            super(souBase);
        }

        @Override
        public double getSou() {
            return 1.1*super.getSou();
        }
    }
}
