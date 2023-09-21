package vectorAndMatrix.personData.entities;

public class PersonInfo {
    private final char gender;
    private final double height;

    public PersonInfo(double height, char gender) {
        this.height = height;
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }
}
