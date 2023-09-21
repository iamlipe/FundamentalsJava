package inheritanceAndPolymorphism.geometricShapes.entities;

import inheritanceAndPolymorphism.geometricShapes.entities.enums.Color;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
