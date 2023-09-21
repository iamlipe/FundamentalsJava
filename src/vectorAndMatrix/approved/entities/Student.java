package vectorAndMatrix.approved.entities;

public class Student {
    private final String name;
    private final double p1;
    private final double p2;

    public Student(String name, double p1, double p2) {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return (this.p2 + this.p1) / 2;
    }
}
