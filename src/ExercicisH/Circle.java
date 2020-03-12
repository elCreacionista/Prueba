package ExercicisH;

class Circulo {


    public static void main(String[] args) {
        Circulo c1 = new Circulo(3, "RED");
        Cylinder c2 = new Cylinder(3,10);

        System.out.println(c1.getArea());
        System.out.println(c2.getArea());

        System.out.println(c2.toString());
        System.out.println(c2.getArea());


    }


    final double PI = 3.14;

    double radius;
    String color;
    Circulo(){}
    Circulo(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return 2 * PI * (Math.pow(this.radius,2));
    }
    @Override
    public String toString(){
        return this.getClass().toString();
    }

}
class Cylinder extends Circulo {
    double height;

    Cylinder() {
    }

    Cylinder(double radius) {
        this.radius = radius;
    }

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return 3.14;
    }

    public double getArea(){
        return super.getArea() * 2 + height * ( 2 * PI * radius);
    }
    @Override
    public String toString(){
        return super.toString();
    }
}


