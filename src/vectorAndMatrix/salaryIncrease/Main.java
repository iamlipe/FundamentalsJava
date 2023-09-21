package vectorAndMatrix.salaryIncrease;

import vectorAndMatrix.salaryIncrease.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.println("How many employee will be registred?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + i + 1 + ":");

            System.out.print("Id:");
            long id = sc.nextLong();

            sc.nextLine();

            System.out.print("Name:");
            String name = sc.nextLine();

            System.out.print("Salary:");
            double salary = sc.nextDouble();

            Employee newEmployee = new Employee(id, name, salary);

            employees.add(newEmployee);
        }

        System.out.print("Enter the employee id that will have salary increase:");
        long id = sc.nextLong();

        System.out.print("Enter the percentage:");
        double percentage = sc.nextDouble();

        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee != null) {
            employee.increaseSalary(percentage);
        } else {
            System.out.println("This employee does hot exist!");
        }

        System.out.println("List of employees:");

        employees.forEach(e -> System.out.println(e.toString()));
    }

}
