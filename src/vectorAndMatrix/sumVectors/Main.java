package vectorAndMatrix.sumVectors;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos valores vai ter cada vetor?");
        int n = sc.nextInt();

        int[] numbers1 = new int[n];
        int[] numbers2 = new int[n];

        System.out.println("Digite os valores do vetor A:");
        for (int i = 0; i < n; i++) {
            int newNumber = sc.nextInt();
            numbers1[i] = newNumber;
        }

        System.out.println("Digite os valores do vetor B:");
        for (int i = 0; i < n; i++) {
            int newNumber = sc.nextInt();
            numbers2[i] = newNumber;
        }

        System.out.println("VETOR RESULTANTE:");

        for (int i = 0; i < n; i++) {
            System.out.println(numbers1[i] + numbers2[i]);
        }

        sc.close();
    }

}
