package vectorAndMatrix.averageHeigh;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] vector = new double[n];

        for (int i = 0; i < n; i++) {
            vector[i] = sc.nextDouble();
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += vector[i];
        }

        System.out.printf("AVERAGE HEIGHT: %.2f", sum / 3);

        sc.close();
    }
}
