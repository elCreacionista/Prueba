package animales;

public class Tile {

    Noise noise;


        public String toSting(){
            return "Tile";
        }
}
class City extends Tile{}
class Grass extends Tile{
    @Override
    public String toSting(){
        return "Grass";
    }
}
class Forest extends Tile{
    @Override
    public String toSting(){
        return "Forest";
    }
}
class Mont extends Tile{
    @Override
    public String toSting(){
        return "Mont";
    }
}
class Water extends Tile{}
class Sea extends Water {
    @Override
    public String toSting() {
        return "Sea";
    }
}
class River extends Water{}
