package lambdaExpressions.employees;

import lambdaExpressions.employees.entities.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "/src/lambdaExpressions/employees/input/employees.csv";

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                String email = fields[1];
                Double salary = Double.parseDouble(fields[2]);

                Employee employee = new Employee(name, email, salary);

                employees.add(employee);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        List<String> emails = employees.stream()
                .filter(e -> e.getSalary() > salary)
                .map(e -> e.getEmail())
                .sorted()
                .collect(Collectors.toList());

        System.out.printf("Email of people whose salary is more than %.2f: %n", salary);

        emails.forEach(System.out::println);

        double sum = employees.stream()
                .filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
                .map(e -> e.getSalary())
                .reduce(0.0, (a, b) -> a + b);

        System.out.printf("Sum of salary of people whose name starts with 'M': %.2f %n", sum);

        sc.close();
    }
}
