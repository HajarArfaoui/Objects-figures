import java.awt.*;
import java.util.Arrays;

//Shape interface contains the common methods between all the shapes(square,rectangle,circle and trapeze)
public interface Shape {
    ColorUtils col = new ColorUtils();
    
    //Since the aim of the code is to print the main info about the shape, so draw() method is optional.
    Shape draw();
    int getArea();
    Color getColor();
}

class Square implements Shape {
    int side;
    Color color;

    Square(Color color, int side) {
        this.color = color;
        this.side = side;
    }

    @Override
    public int getArea() {
        return side*side;
    }

    @Override
    public Color getColor() {

        return color;
    }

    int getSide() {

        return this.side;
    }

    @Override
    public String toString() {
        return "Figure: square, area: " + getArea() + " m², side length: " + getSide()+
                ", color :" + col.getColorNameFromColor(color)+".";
    }

    @Override
    public Shape draw() {
        return new Square(getColor(),side) ;
    }


}


class Triangle implements Shape {
    int side1, side2;
    double side3;
    public Color color;

    public Triangle(int side1, int side2, double side3, Color color) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = color;
    }

    double[] getSide() {
        double [] arr = {side1, side2, side3};
        return arr;
    }

    double getHypotenuse() {
        Arrays. sort(getSide());
        return getSide()[getSide().length-1];
    }

    @Override
    public Shape draw() {

       return new Triangle(side1, side2, getHypotenuse(),getColor());
    }

    @Override
    public Color getColor() {

        return color;
    }

    public String toString() {
        return "Figure: triangle, area: " + getArea() + " m², hypotenuse " + getHypotenuse()+
                ", color :" + col.getColorNameFromColor(color)+".";
    }

    @Override
    public int getArea(){
        //calculate the semiperimeter 's' using Heron's Formula
        int s = (int) (side1+side2+side3)/2;
        //calculate the area with 3 sides given
        int area = (int) Math.sqrt((s*(s-side1)*(s-side2)*(s-side3)));
        return area;
    }
}

class Circle implements Shape {
    int radius;
    Color color;

    public Circle(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    int getRadius() {
        return radius;
    }

    @Override
    public Shape draw() {

        return new Circle(getRadius(),getColor());
    }

    @Override
    public int getArea() {

        return  ((int) (Math.PI * Math.pow(radius, 2)));
    }

    @Override
    public Color getColor() {

        return color;
    }

    public String toString() {
        return "Figure: circle, area:" + getArea() + " m², radius: " +  getRadius() +
                "m, Color : " + col.getColorNameFromColor(color)+".";
    }
}

class Trapeze implements Shape {
    int base1, base2, h;
    Color color;

    public Trapeze(Color color, int base1, int base2, int h) {
        this.base1 = base1;
        this.base2 = base2;
        this.h = h;
        this.color = color;
    }

    int[] side() {
        int [] arr = {base1, base2, h};
        return arr;
    }

    @Override
    public Shape draw() {
        return new Trapeze(getColor(),base1,base2,h);
    }

    @Override
    public int getArea() {
        return (base1+base2)/2*h;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public String toString() {
        return "Figure: trapeze, area " + getArea() + " m², sides length: " +  Arrays.toString(side()) +
                "m, Color : " + col.getColorNameFromColor(color)+ ".";
    }
}
