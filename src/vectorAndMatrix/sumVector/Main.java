package vectorAndMatrix.sumVector;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos numeros voce vai digitar?");
        int n = sc.nextInt();
        double[] numbers = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Digite um numero:");
            double num = sc.nextDouble();
            numbers[i] = num;
        }

        double sum = 0.0;

        System.out.print("VALORES = ");

        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i]);
            System.out.print(" ");
            sum += numbers[i];
        }

        System.out.println();

        double avg = sum / n;

        System.out.printf("SOMA = %.2f %n", sum);
        System.out.printf("MEDIA = %.2f", avg);

        sc.close();
    }

}
