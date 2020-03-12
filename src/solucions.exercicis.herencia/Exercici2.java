package solucions.exercicis.herencia;

public class Exercici2 {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println(c);
        System.out.printf("Area: %.2f\n", c.getArea());
        System.out.println();

        Cylinder cl = new Cylinder(10, 5);
        System.out.println(cl);
        System.out.printf("Volume: %.2f\n", cl.getVolume());
        System.out.printf("Area: %.2f\n", cl.getArea());
    }


    static class Circle {
        private double radius = 1.0;
        private String color = "red";

        public Circle() {

        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return this.radius;
        }

        public double getArea() {
            return Math.PI * this.radius*this.radius;
        }

        public String toString() {
            return String.format("Circle with radius: %.2f", this.radius);
        }
    }

    static class Cylinder extends Circle {
        private double height = 1.0;

        public Cylinder() {

        }

        public Cylinder(double radius) {
            super(radius);
        }

        public Cylinder(double radius, double height) {
            super(radius);
            this.height = height;
        }

        public double getHeight() {
            return this.height;
        }

        public double getVolume() {
            return super.getArea()*this.height;
        }

        @Override
        public double getArea() {
            return super.getRadius()*2*Math.PI*this.height + 2*super.getArea();
        }

        @Override
        public String toString() {
            return String.format("Cylinder with height: %.2f. SuperClass: %s", this.height, super.toString());
        }
    }
}
