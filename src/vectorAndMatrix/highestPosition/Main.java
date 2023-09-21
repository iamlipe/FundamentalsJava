package vectorAndMatrix.highestPosition;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers will you enter?");
        int n = sc.nextInt();
        double[] numbers = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a number:");
            double newNumber = sc.nextDouble();
            numbers[i] = newNumber;
        }

        double max = 0.0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        int positionMax = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == max) {
                positionMax = i;
            }
        }

        System.out.printf("MAIOR VALOR = %.2f %n", max);
        System.out.printf("POSICAO DO MAIOR VALOR = %d", positionMax);

        sc.close();
    }

}
