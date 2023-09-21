package vectorAndMatrix.heights;

import vectorAndMatrix.heights.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many people will be entered?");
        int n = sc.nextInt();
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Data of the %d th person: %n", i + 1);
            sc.nextLine();

            System.out.print("Name:");
            String name = sc.nextLine();

            System.out.print("Age:");
            int age = sc.nextInt();

            System.out.print("Height:");
            double height = sc.nextDouble();

            Person newPerson = new Person(name, age, height);
            people[i] = newPerson;
        }

        double sumHeight = 0.0;
        int underSixteen = 0;

        for (int i = 0; i < n; i++) {
            sumHeight += people[i].getHeight();

            if (people[i].getAge() < 16) {
                underSixteen += 1;
            }
        }

        double avgHeight = sumHeight / n;
        double percentageUnderSixteen = Double.valueOf(underSixteen) / Double.valueOf(n);

        System.out.printf("Average height: %.2f %n", avgHeight);
        System.out.printf("People under 16: %.2f %n", percentageUnderSixteen);

        for (int i = 0; i < n; i++) {
            if (people[i].getAge() < 16) {
                System.out.println(people[i].getName());
            }
        }

        sc.close();
    }

}
