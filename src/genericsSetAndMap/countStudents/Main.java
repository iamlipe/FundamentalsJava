package genericsSetAndMap.countStudents;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        System.out.print("How many studens for course A: ");
        int numberA = sc.nextInt();

        for (int i = 0; i < numberA; i++) {
            Integer student = sc.nextInt();
            a.add(student);
        }

        System.out.print("How many studens for course B: ");
        int numberB = sc.nextInt();

        for (int i = 0; i < numberB; i++) {
            Integer student = sc.nextInt();
            b.add(student);
        }

        System.out.print("How many studens for course C: ");
        int numberC = sc.nextInt();

        for (int i = 0; i < numberC; i++) {
            Integer student = sc.nextInt();
            c.add(student);
        }

        Set<Integer> allStudents = new HashSet<>(a);
        allStudents.addAll(b);
        allStudents.addAll(c);

        System.out.println("Total students: " + allStudents.size());
    }
}

