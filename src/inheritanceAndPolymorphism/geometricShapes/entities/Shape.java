package inheritanceAndPolymorphism.geometricShapes.entities;

import inheritanceAndPolymorphism.geometricShapes.entities.enums.Color;

public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract double area();
}

