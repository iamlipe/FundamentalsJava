package vectorAndMatrix.approved;

import vectorAndMatrix.approved.entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos alunos serao digitados?");
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Digite nome, primeira e segunda nota do %dº aluno: %n", i + 1);
            sc.nextLine();

            String name = sc.nextLine();
            double p1 = sc.nextDouble();
            double p2 = sc.nextDouble();

            Student newStudent = new Student(name, p1, p2);
            students[i] = newStudent;
        }

        System.out.println("Alunos aprovados:");

        for (int i = 0; i < n; i++) {
            if (students[i].getAverage() >= 6.0) {
                System.out.println(students[i].getName());
            }
        }

        sc.close();
    }
}
