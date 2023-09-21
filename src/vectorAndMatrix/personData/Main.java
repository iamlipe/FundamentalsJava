package vectorAndMatrix.personData;

import vectorAndMatrix.personData.entities.PersonInfo;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas serao digitadas?");
        int n = sc.nextInt();
        PersonInfo[] data = new PersonInfo[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Altura da %dª pessoa: ", i + 1);
            double height = sc.nextDouble();
            sc.nextLine();

            System.out.printf("Genero da %dª pessoa: ", i + 1);
            char gender = sc.nextLine().charAt(0);

            PersonInfo newData = new PersonInfo(height, gender);
            data[i] = newData;
        }

        double maxHeight = 0.0;
        double minHeight = 0.0;
        double sumHeighWomen = 0.0;
        int sumWomen = 0;
        int sumMen = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxHeight = data[i].getHeight();
                minHeight = data[i].getHeight();
            } else {
                if (data[i].getHeight() > maxHeight) {
                    maxHeight = data[i].getHeight();
                }

                if (data[i].getHeight() < minHeight) {
                    minHeight = data[i].getHeight();
                }
            }

            if (data[i].getGender() == 'M') {
                sumMen += 1;
            }

            if (data[i].getGender() == 'F') {
                sumWomen += 1;

                sumHeighWomen += data[i].getHeight();
            }
        }

        double averageHeightWomen = sumHeighWomen / sumWomen;

        System.out.printf("Menor altura = %.2f %n", minHeight);
        System.out.printf("Maior altura = %.2f %n", maxHeight);
        System.out.printf("Media das alturas das mulheres = %.2f %n", averageHeightWomen);
        System.out.printf("Numero de homens = %d", sumMen);

        sc.close();
    }

}
