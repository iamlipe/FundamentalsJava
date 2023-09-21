package vectorAndMatrix.pairNumbers;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos numeros voce vai digitar?");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite um numero:");
            int num = sc.nextInt();
            numbers[i] = num;
        }

        System.out.println("NUMEROS PARES:");

        int quantityPairs = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i]);
                System.out.print(" ");
                quantityPairs += 1;
            }
        }

        System.out.println();
        System.out.printf("QUANTIDADE DE PARES = %d", quantityPairs);

        sc.close();
    }
}
