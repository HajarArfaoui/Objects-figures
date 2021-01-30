import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public interface ShapeGenerator {
    //gen is a random variable
    Random gen = new Random();
    Shape GenerateShape();
}


class SquareGen implements ShapeGenerator {
    int side = gen.nextInt(50)+5;
    @Override
    public Shape GenerateShape() {
        return new Square(new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)),side);
    }
}

class TriangleGen implements ShapeGenerator {

    @Override
    public Shape GenerateShape() {
        int side1, side2;
        double side3;

        side1 = gen.nextInt(50)+5;
        side2 = gen.nextInt(50)+5;
        //Supposing that triangle is a right triangle
        side3 = new BigDecimal(Math.sqrt((side1*side1+side2*side2))).setScale(2, RoundingMode.UP).doubleValue();


        return new Triangle(side1, side2, side3, new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
    }
}
class CircleGen implements ShapeGenerator {

    @Override
    public Shape GenerateShape() {
        int radius =gen.nextInt(80)+5;
        return new Circle(radius,
                new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
    }
}
class TrapezeGen implements ShapeGenerator{

    @Override
    public Shape GenerateShape() {
        int base1 = gen.nextInt(50)+5;
        int base2 = gen.nextInt(70)+5;
        int h = gen.nextInt(40)+5;


        return new Trapeze(new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)),
                base1, base2, h);
    }
}