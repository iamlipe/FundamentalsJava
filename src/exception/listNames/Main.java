package exception.listNames;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            String[] names = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(names[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index array!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!JJ");
        }

        System.out.println("End of program!");

    }
}
