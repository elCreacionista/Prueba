package Ecosystem;

public class MapGenerator {
    private int[][] mapa;
    private int x;
    private int y;
    private static int mapascreados = 0;

    public MapGenerator(int height, int width) {
        this.x = height;
        this.y = width;
        GenerateMapa();
        while (!ContarCosas(60,0,60,0)){GenerateMapa();}
    }

    private boolean ContarCosas(int min_bosque, int min_rio, int min_mar, int min_monte){
        int mar = 0, rio = 0, bosque = 0, monte = 0;
        for (int i = 0; i <this.mapa.length ; i++) {
            for (int j = 0; j <this.mapa[0].length ; j++) {
                switch (mapa[i][j]){
                    case -1: case 0: mar++; break;
                    case 1: case 2: break;
                    case 3: monte++; break;
                    case 4: bosque++; break;
                    case 5: rio++; break;
                    default:
                        System.out.println("Smth went wrong");
                        break;

                }
            }
        }
        System.out.println( bosque + " bosques. " + rio +  " rios. " + mar + " mares. " + monte + " montes.");
        return (min_bosque < bosque) && (min_mar < mar) && (min_monte < monte) && (min_rio < rio);
    }





    public int[][] getMapa(){
        return this.mapa;
    }

    public int[][] GenerateMapa() {
        mapascreados++;
        System.out.println("Mapa numero: " + mapascreados);
        this.mapa = new int[x][y];
        int altura = 0;

        //GENERAR MAPA
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.mapa[i][j] = altura;

                if (i == 0 || j == 0) {
                    switch ((int) (Math.random() * 3)) {
                        case 0:
                            altura++;
                            break;
                        case 1:
                            break;
                        case 2:
                            altura--;
                            break;
                    }
                } else {
                    switch ((int) (Math.random() * 2)) {
                        case 0:
                            this.mapa[i][j] = this.mapa[i - 1][j];
                            break;
                        case 1:
                            this.mapa[i][j] = this.mapa[i][j - 1];
                            break;
                    }
                }
                if (altura <= 0) {
                    altura = 0;
                }
                if (altura >= 3) {
                    altura = 2;
                }
            }
        }


        //LIMPIADOR DEL MAPA
        for (int i = x - 1; i >= 0; i--) {
            for (int j = 0; j < y; j++) {
                if (i != x - 1 && j != 0) {
                    switch ((int) (Math.random() * 2)) {
                        case 0:
                            this.mapa[i][j] = this.mapa[i + 1][j];
                            break;
                        case 1:
                            this.mapa[i][j] = this.mapa[i][j - 1];
                            break;
                    }
                }
            }
        }

        //LIMPIADOR 2 DEL MAPA
        for (int i = 0; i < x; i++) {
            for (int j = y - 1; j >= 0; j--) {
                if (i != 0 && j != y - 1) {
                    switch ((int) (Math.random() * 2)) {
                        case 0:
                            this.mapa[i][j] = this.mapa[i - 1][j];
                            break;
                        case 1:
                            this.mapa[i][j] = this.mapa[i][j + 1];
                            break;
                    }
                }
            }
        }
        //GENERADOR DE MONTAÑAS
        crearMontes(100, 300);

        //GENERADOR DE BOSQUES
        crearBosques(5, 3);

        //ESTABILIZADOR DE TERRENO
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (this.mapa[i][j] != 3) {
                    if (i < x - 2) {
                        if (this.mapa[i][j] == this.mapa[i + 2][j]) this.mapa[i + 1][j] = this.mapa[i][j];
                    }
                    if (j < y - 2) {
                        if (this.mapa[i][j] == this.mapa[i][j + 2]) this.mapa[i][j + 1] = this.mapa[i][j];
                    }
                }
            }
        }

        //RIOS
        crearRios(10);


        return this.mapa;
    }

    private void crearBosques(double cant_bosques, double tamanio_bosques) {
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
                if (this.mapa[i][j] != 0) {
                    if ((int) (Math.random() * cant_bosques) == 0) {
                        int guardar_i = i;
                        int guardar_j = j;
                        for (int k = 0; k < (int) (Math.random() * tamanio_bosques); k++) {
                            if (this.mapa[i][j] != 0) {
                                switch ((int) (Math.random() * 4)) {
                                    case 0:
                                        if (j < this.mapa[0].length - 1) {
                                            this.mapa[i][j] = 4;
                                            j++;
                                        } else {
                                            j--;
                                        }
                                        break;
                                    case 1:
                                        if (j > 0) {
                                            this.mapa[i][j] = 4;
                                            j--;
                                        } else {
                                            j++;
                                        }
                                        break;
                                    case 2:
                                        if (i < this.mapa.length - 1) {
                                            this.mapa[i][j] = 4;
                                            i++;
                                        } else {
                                            i--;
                                        }
                                        break;
                                    case 3:
                                        if (i > 0) {
                                            this.mapa[i][j] = 4;
                                            i--;
                                        } else {
                                            i++;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            } else if (j > 0) j--;
                            else j++;
                        }
                        i = guardar_i;
                        j = guardar_j;
                    }
                }
            }
        }
    }

    private void crearMontes(double cant_montes, double tamanio_montes) {
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
                if (this.mapa[i][j] != 0) {
                    if ((int) (Math.random() * cant_montes) == 0) {
                        int guardar_i = i;
                        int guardar_j = j;
                        for (int k = 0; k < (int) (Math.random() * tamanio_montes); k++) {
                            switch ((int) (Math.random() * 4)) {
                                case 0:
                                    if (j < this.mapa[0].length - 1) {
                                        this.mapa[i][j] = 3;
                                        j++;
                                    } else {
                                        j--;
                                    }
                                    break;
                                case 1:
                                    if (j > 0) {
                                        this.mapa[i][j] = 3;
                                        j--;
                                    } else {
                                        j++;
                                    }
                                    break;
                                case 2:
                                    if (i < this.mapa.length - 1) {
                                        this.mapa[i][j] = 3;
                                        i++;
                                    } else {
                                        i--;
                                    }
                                    break;
                                case 3:
                                    if (i > 0) {
                                        this.mapa[i][j] = 3;
                                        i--;
                                    } else {
                                        i++;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        i = guardar_i;
                        j = guardar_j;
                    }
                }
            }
        }
    }

    private void crearRios(double cant_rios) {
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
                if (this.mapa[i][j] == 3) {
                    char direccion;
                    if (i == 0) direccion = 'D';/*DOWN*/
                    else if (j == this.mapa[0].length - 1) direccion = 'W';/*WEST*/
                    else if (i == this.mapa.length - 1) direccion = 'U';/*UP*/
                    else if (j == 0) direccion = 'E';/*EAST*/
                    else switch ((int) (Math.random() * 4)) {
                            case 0:
                                direccion = 'D';
                                break;
                            case 1:
                                direccion = 'W';
                                break;
                            case 2:
                                direccion = 'U';
                                break;
                            case 3:
                                direccion = 'E';
                                break;
                            default:
                                direccion = 'X';
                                break;
                        }
                    if ((int) (Math.random() * cant_rios) == 0) {

                        int i_rios = i;
                        int j_rios = j;
                        switch (direccion) {
                            case 'E':
                                if (j_rios >= this.mapa.length - 1) break;
                                j_rios++;
                                while (this.mapa[i_rios][j_rios] == 1 || this.mapa[i_rios][j_rios] == 2 || this.mapa[i_rios][j_rios] == 4) {
                                    switch ((int) (Math.random() * 3)) {
                                        case 0:
                                            if (i_rios != this.mapa.length - 1) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                i_rios++;
                                            }
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            if (i_rios != 0) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                i_rios--;
                                            }
                                            break;
                                    }
                                    this.mapa[i_rios][j_rios] = 5;
                                    if (j_rios >= this.mapa.length - 1) break;
                                    j_rios++;
                                    if (j_rios >= this.mapa.length - 1) break;
                                }
                                break;
                            case 'W':
                                if (j_rios <= 0) break;
                                j_rios--;
                                while (this.mapa[i_rios][j_rios] == 1 || this.mapa[i_rios][j_rios] == 2 || this.mapa[i_rios][j_rios] == 4) {
                                    switch ((int) (Math.random() * 3)) {
                                        case 0:
                                            if (i_rios != this.mapa.length - 1) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                i_rios++;
                                            }
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            if (i_rios != 0) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                i_rios--;
                                            }
                                            break;
                                    }
                                    this.mapa[i_rios][j_rios] = 5;
                                    if (j_rios <= 0) break;
                                    j_rios--;
                                    if (j_rios <= 0) break;
                                }
                                break;

                            case 'D':
                                if (i_rios >= this.mapa.length - 1) break;
                                i_rios++;
                                while (this.mapa[i_rios][j_rios] == 1 || this.mapa[i_rios][j_rios] == 2 || this.mapa[i_rios][j_rios] == 4) {
                                    switch ((int) (Math.random() * 3)) {
                                        case 0:
                                            if (j_rios != this.mapa.length - 2) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                j_rios++;
                                            }
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            if (j_rios != 1) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                j_rios--;
                                            }
                                            break;
                                    }
                                    this.mapa[i_rios][j_rios] = 5;
                                    if (i_rios >= this.mapa.length - 1) break;
                                    i_rios++;
                                    if (i_rios >= this.mapa.length - 1) break;
                                }
                                break;

                            case 'U':
                                if (i_rios <= 0) break;
                                i_rios--;
                                while (this.mapa[i_rios][j_rios] == 1 || this.mapa[i_rios][j_rios] == 2 || this.mapa[i_rios][j_rios] == 4) {
                                    switch ((int) (Math.random() * 3)) {
                                        case 0:
                                            if (j_rios != this.mapa.length - 2) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                j_rios++;
                                            }
                                            break;
                                        case 1:
                                            break;
                                        case 2:
                                            if (j_rios != 1) {
                                                this.mapa[i_rios][j_rios] = 5;
                                                j_rios--;
                                            }
                                            break;
                                    }
                                    this.mapa[i_rios][j_rios] = 5;
                                    if (i_rios <= 0) break;
                                    i_rios--;
                                    if (i_rios <= 0) break;
                                }
                                break;

                        }


                    }

                }
            }
        }
    }


}
