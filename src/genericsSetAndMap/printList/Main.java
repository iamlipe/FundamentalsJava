package genericsSetAndMap.printList;


import genericsSetAndMap.printList.service.PrintService;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many items will have the list: ");
        int n = sc.nextInt();
        PrintService<Integer> printService = new PrintService<>();

        for (int i = 0; i < n; i++) {
            int item = sc.nextInt();
            printService.addItem(item);
        }

        System.out.println("First: " + printService.first());

        printService.print();
    }
}
