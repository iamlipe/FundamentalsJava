package vectorAndMatrix.averagePairs;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos elementos vai ter o vetor?");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero:");
            int num = sc.nextInt();
            numbers[i] = num;
        }

        int sumPairs = 0;
        int quantityPairs = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                sumPairs += numbers[i];
                quantityPairs += 1;
            }
        }

        if (quantityPairs == 0) {
            System.out.println("NENHUM NUMERO PAR");
        } else {
            double avgPairs = (double) sumPairs / quantityPairs;

            System.out.printf("MEDIA DOS PARES = %.2f", avgPairs);
        }

        sc.close();
    }

}
