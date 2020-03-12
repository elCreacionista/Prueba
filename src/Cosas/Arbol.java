package Cosas;


    import java.awt.*;

    public class Arbol {


        Turtle arbol = new Turtle(700,500, "ARBOL");
        int nramas;
        int preset;

        public static void main(String[] args) {

            Arbol p = new Arbol(1,40,100,3);
            //Arbol p = new Arbol(9);
            for (int i = 0; i <10 ; i++) {

                p.arbol.goTo(-600,-250 - i);
                p.arbol.resetAngle();
                p.arbol.turnRight(90);
                p.arbol.forward(1200,Color.GREEN);
            }
            p.arbol.show();

        }
        Arbol(int preset){
            this.preset = preset;
            this.nramas = preset * 10;
            //this.crearArbol(preset * 50,preset);
        }
        Arbol(int narboles, int nramas, int tamaniotronco, int anchotronco){
            this.nramas = nramas;
            for (int i = 0; i < narboles ; i++) {

                crearUnArbol(i * 37, tamaniotronco,anchotronco);
            }
        }

        public void crearUnArbol(int posi, int tamaniotronco, int anchotronco){
            crearArbol(posi,tamaniotronco,anchotronco);
        }
        public void crearArbol(int posi, int tamanioTronco, int anchoTronco){
            for (int i = -anchoTronco + posi - 400; i <anchoTronco + posi - 400; i++) {
                arbol.resetAngle();
                int randN = (int)(Math.random()*5)-2;
                arbol.goTo(i,-250 + randN);
                arbol.forward(tamanioTronco, Color.BLACK);
            }



            arbol.goTo(anchoTronco,-250);
            arbol.forward(tamanioTronco, Color.BLACK);

            for (int i = 0; i < this.nramas ; i++) {
                int largo = (int) (Math.random() * tamanioTronco * 0.5 + tamanioTronco * 0.1);
                int pos = (int) (Math.random() * tamanioTronco * 0.3);
                int angulo = (int) (Math.random() * 180) - 90;
                int direccion;
                for (int j = 0; j < 7 ; j++) {
                    hojas();
                    arbol.forward(0,Color.BLACK);
                    arbol.resetAngle();

                    if (angulo < 0){
                        arbol.goTo(anchoTronco + posi - 400,-250 + tamanioTronco - pos);
                        arbol.turnLeft(angulo);
                        arbol.forward(largo, Color.BLACK);
                    }
                    else{
                        arbol.goTo(-anchoTronco + posi - 400,-250 + tamanioTronco - pos);
                        arbol.turnRight(-angulo);
                        arbol.forward(largo, Color.BLACK);
                    }

                    crearRamitas(true, largo);
                }

            }

        }

        public void hojas(){
            int tamanio = 32;
            this.arbol.turnRight((int)(Math.random()*100));
            for (int i = 0; i < tamanio ; i++) {
                this.arbol.forward(1, Color.GREEN);
                if ((float) i/tamanio < 0.5){
                    this.arbol.turnLeft(i);
                }
                else{
                    this.arbol.turnLeft(tamanio - i);
                }
            }


        }



        public void crearRamitas(boolean hayramitas, int tamanioramita){
            if (hayramitas) {
                int tamanio = (int) ((Math.random() * tamanioramita * 0.2) + tamanioramita * 0.3);
                int pos = (int) (Math.random() * 10);
                arbol.forward(- pos, Color.BLACK);
                int angulo = (int) (Math.random() * 180) - 90;
                arbol.turnRight(angulo);
                arbol.forward(tamanio, Color.BLACK);
                this.hojas();
                hojas();
            }
        }


}
