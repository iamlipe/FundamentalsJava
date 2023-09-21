package enumerationAndComposition.humanResources;

import enumerationAndComposition.humanResources.entities.Department;
import enumerationAndComposition.humanResources.entities.HourContract;
import enumerationAndComposition.humanResources.entities.Worker;
import enumerationAndComposition.humanResources.entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        String level = sc.nextLine();
        WorkerLevel workerLevel = WorkerLevel.valueOf(level);

        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Department department = new Department(departmentName);
        Worker worker = new Worker(workerName, workerLevel, baseSalary, department);

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + i + " data:");

            System.out.print("Date (DD/MM/YYYY): ");
            String dataString = sc.next();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dataString, formatter1);

            HourContract contract = new HourContract(date, valuePerHour, hours);

            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }


}
