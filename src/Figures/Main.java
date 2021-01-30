import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Get the maximum possible shapes number
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the maximum number of Shapes: ");
        int num= in.nextInt();

        // create a table with a random size but not bigger than 'num' value.
        Shape[] array = new Shape[(ShapeGenerator.gen.nextInt(num - 1) + 1)];

        Map<Integer, ShapeGenerator> fig = new LinkedHashMap<Integer, ShapeGenerator>();
        fig.put(1, new CircleGen());
        fig.put(2, new SquareGen());
        fig.put(3, new TrapezeGen());
        fig.put(4, new TriangleGen());

        //fill the array with random shapes
        for (int i = 0; i < array.length; i++) {
            array[i] = fig.get(ShapeGenerator.gen.nextInt(fig.size()) + 1).GenerateShape();
        }
        //display the figures data.
        for (Shape s : array) {
            System.out.println(s.toString());

        }
    }
}
