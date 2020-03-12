package Ecosystem;

public class MapTransformer {
    private MapGenerator mg;
    public MapTransformer(MapGenerator mg){
        this.mg = mg;
    }


    public Casilla[][] Transform(){
        int[][] mapa = this.mg.getMapa();
        Casilla[][] map = new Casilla[mapa.length][mapa[0].length];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length ; j++) {
                switch (mapa[i][j]){
                    case -1:
                    case 0:
                    case 5:
                        map[i][j] = new Agua();
                        break;
                    case 1:
                    case 2:
                    case 3:
                        map[i][j] = new Tierra();
                        break;
                    case 4:
                        map[i][j] = new Arbol();
                        break;
                    default:
                        System.out.println("Smth went wrong");
                        break;

                }
            }
        }
        return map;
    }
}

