package inheritanceAndPolymorphism.geometricShapes;

import inheritanceAndPolymorphism.geometricShapes.entities.Circle;
import inheritanceAndPolymorphism.geometricShapes.entities.Rectangle;
import inheritanceAndPolymorphism.geometricShapes.entities.Shape;
import inheritanceAndPolymorphism.geometricShapes.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int numberShapes = sc.nextInt();

        List<Shape> shapes = new ArrayList<>();

        for (int i = 1; i <= numberShapes; i++) {
            System.out.println("Shape #" + i + " data:");

            System.out.print("Rectangle or circle (r/c)? ");
            char typeShape;

            do {
                typeShape = sc.next().toLowerCase().charAt(0);

                if (typeShape != 'r' && typeShape != 'c') {
                    System.out.println("Enter a valid shape");
                }
            } while (typeShape != 'r' && typeShape != 'c');

            System.out.print("Color (BLACK/BLUE/RED): ");
            String shapeColor = sc.next();

            Color color = Color.valueOf(shapeColor);

            if (typeShape == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();

                System.out.print("Height: ");
                double height = sc.nextDouble();

                Shape shape = new Rectangle(color, width, height);
                shapes.add(shape);
            }

            if (typeShape == 'c') {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();

                Shape shape = new Circle(color, radius);
                shapes.add(shape);
            }
        }

        System.out.println("SHAPE AREAS");

        for (Shape s : shapes) {
            System.out.printf("%.2f %n", s.area());
        }

        sc.close();
    }
}
