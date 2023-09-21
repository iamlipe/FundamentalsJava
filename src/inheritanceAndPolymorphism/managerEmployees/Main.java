package inheritanceAndPolymorphism.managerEmployees;

import inheritanceAndPolymorphism.managerEmployees.entities.Employee;
import inheritanceAndPolymorphism.managerEmployees.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int numberEmployees = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= numberEmployees; i++) {
            System.out.println("Employee #" + i + " data:");

            System.out.print("Outsourced (y/n)? ");

            char outsourced;

            do {
                outsourced = sc.next().toLowerCase().charAt(0);

                if (outsourced != 'y' && outsourced != 'n') {
                    System.out.println("Enter a valid answer");
                }
            } while (outsourced != 'y' && outsourced != 'n');

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            Employee employee;

            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();

                employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                employees.add(employee);
            }

            if (outsourced == 'n') {
                employee = new Employee(name, hours, valuePerHour);
                employees.add(employee);
            }
        }

        System.out.println("PAYMENTS:");

        for (Employee e : employees) {
            System.out.println(e.toString());
        }

        sc.close();
    }
}
