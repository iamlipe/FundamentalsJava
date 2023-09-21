package inheritanceAndPolymorphism.geometricShapes.entities;

import inheritanceAndPolymorphism.geometricShapes.entities.enums.Color;

public class Rectangle extends Shape {
    private final Double width;
    private final Double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
