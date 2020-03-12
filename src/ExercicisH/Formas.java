package ExercicisH;

public class Formas {

    public static void main(String[] args) {

        Shape s1 = new Shape("green",false);
        Circle c1 = new Circle(1.3,"caca", false);
        Rectangle r = new Rectangle(20,20,"ambrosio",true);
        Square sq1 = new Square(r.getWidth(), r.getColor(), r.isFilled());

        System.out.println(s1.toString());
        System.out.println(c1.toString());
        System.out.println(r.toString());
        System.out.println(sq1.toString());
        System.out.println("OSTIA PILOTES UUUH QUE BONES M'ENCANTEN");

    }


}

class Shape{



    String color;
    boolean filled;

    Shape(){}
    Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public String Filled(){
        if (this.filled){
            return "filled";
        }
        else{
            return "not filled";
        }
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public String toString(){
        return "Shape with color of " + this.color + " and " + Filled() + "";
    }
}
class Circle extends Shape{

    public static final double PI = 3.14;

    double radius;
    Circle(){}
    Circle(double radius){
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled){
        super(color,filled);
        this.radius = radius;
    }

    public double getArea(){
        return 2;
    }
    public double getPerimeter(){
        return 2;
    }
    @Override
    public String toString(){
        return "Circle with radius " + radius + ", which is a subclass of " + super.toString();
    }
}
class Rectangle extends Shape{

    double width;
    double lenght;

    Rectangle(){}
    Rectangle(double width, double lenght){
        this.width = width;
        this.lenght = lenght;
    }
    Rectangle(double width, double lenght, String color, boolean filled){
        super(color,filled);
        this.width = width;
        this.lenght = lenght;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public double getLenght() {
        return lenght;
    }

    public double getArea(){
        return 2;
    }
    public double getPerimeter(){
        return 2.5;
    }
    @Override
    public String toString(){
        return "Rectangle with width=" + this.width + ", and lenght=" + this.lenght + ", which is a subclass of " + super.toString();
    }
}
class Square extends Rectangle{

    double side;

    Square(){}
    Square(double side){
        super(side, side);
        this.side = side;
    }
    Square(double side, String color, boolean filled){
        super(side,side,color,filled);
        this.side = side;
    }
    public double getSide(){
        return this.side;
    }
    public void setSide(double side){
        this.side = side;
    }
    @Override
    public void setWidth(double width){
        this.width = width;
    }
    @Override
    public void setLenght(double lenght){
        this.lenght = lenght;
    }
    @Override
    public String toString(){
        return "Square with side=" + side + ", which is a subclass of " + super.toString();
    }
}

