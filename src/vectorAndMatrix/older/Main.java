package vectorAndMatrix.older;

import vectorAndMatrix.older.entities.PersonWithAge;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas voce vai digitar?");
        int n = sc.nextInt();
        PersonWithAge[] people = new PersonWithAge[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Dados da %dº person: %n", i + 1);
            sc.nextLine();

            System.out.print("Name:");
            String name = sc.nextLine();

            System.out.print("Age:");
            int age = sc.nextInt();

            PersonWithAge newPerson = new PersonWithAge(name, age);
            people[i] = newPerson;
        }

        if (people.length > 0) {
            PersonWithAge older = people[0];

            for (int i = 1; i < n; i++) {
                if (people[i].getAge() > older.getAge()) {
                    older = people[i];
                }
            }

            System.out.print("PESSOA MAIS VELHA: ");
            System.out.println(older.getName());
        } else {
            System.out.println("Nenhuma pessoa foi cadastrada!");
        }

        sc.close();
    }

}
