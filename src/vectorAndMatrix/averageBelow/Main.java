package vectorAndMatrix.averageBelow;

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
            System.out.print("Digite um numero:");
            double num = sc.nextDouble();
            numbers[i] = num;
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }

        double avg = sum / n;

        System.out.printf("MEDIA DO VETOR = %.3f %n", avg);
        System.out.println("ELEMENTOS ABAIXO DA MEDIA:");

        for (int i = 0; i < n; i++) {
            if (numbers[i] < avg) {
                System.out.println(numbers[i]);
            }
        }

        sc.close();
    }

}
