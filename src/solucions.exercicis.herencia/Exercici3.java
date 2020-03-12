public class Exercici3 {
    public static void main(String[] args) {
    }

    static class Shape {
        private String color;
        private boolean filled;

        public Shape() {

        }

        public Shape(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
        }

        public String getColor() {
            return this.color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        @Override
        public String toString() {
            return String.format("Shape with color %s and %s\n", this.color, this.filled ? "filled" : "not filled");
        }
    }

    static class Circle extends Shape {
        private double radius;

        public Circle() {

        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius, String color, boolean filled) {
            super(color, filled);
            this.radius = radius;
        }

        public double getRadius() {
            return this.radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI*this.radius*this.radius;
        }

        public double getPerimeter() {
            return Math.PI*2*this.radius;
        }

        @Override
        public String toString() {
            return String.format("Circle with radius=%.2f, which is a subclass of %s",
                    this.radius, super.toString());
        }
    }

    static class Rectangle extends Shape {
        private double width = 1.0;
        private double lenght = 1.0;

        public Rectangle() {

        }

        public Rectangle(double width, double lenght) {
            this.width = width;
            this.lenght = lenght;
        }

        public Rectangle(double width, double lenght, String color, boolean filled) {
            super(color, filled);
            this.width = width;
            this.lenght = lenght;
        }

        public double getWidth() {
            return this.width;
        }

        public double getLenght() {
            return this.lenght;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setLenght(double lenght) {
            this.lenght = lenght;
        }

        public double getArea() {
            return this.width*this.lenght;
        }

        public double getPerimeter() {
            return 2*this.width + 2*this.lenght;
        }

        @Override
        public String toString() {
            return String.format("Rectangle with width=%.2f and length=%.2f which is a subclass of %s",
                    this.width, this.lenght, super.toString());
        }
    }

    static class Square extends Rectangle {
        public Square() {

        }

        public Square(double side) {
            super(side, side);
        }

        public Square(double side, String color, boolean filled) {
            super(side, side, color, filled);
        }

        public double getSide() {
            return super.getWidth();
        }

        public void setSide(double side) {
            super.setWidth(side);
            super.setLenght(side);
        }

        @Override
        public void setWidth(double width) {
            setSide(width);
        }

        @Override
        public void setLenght(double length) {
            setSide(length);
        }

        @Override
        public String toString() {
            return String.format("Square with side=%.2f which is a subclass of %s",
                    this.getWidth(), super.toString());
        }
    }
}
