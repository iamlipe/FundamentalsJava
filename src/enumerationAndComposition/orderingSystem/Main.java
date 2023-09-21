package enumerationAndComposition.orderingSystem;

import enumerationAndComposition.orderingSystem.entities.Client;
import enumerationAndComposition.orderingSystem.entities.Item;
import enumerationAndComposition.orderingSystem.entities.Order;
import enumerationAndComposition.orderingSystem.entities.Product;
import enumerationAndComposition.orderingSystem.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("Email: ");
        String clientEmail = sc.nextLine();

        System.out.print("BirthDate (DD/MM/YYYY): ");
        String clientbirthDate = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(clientbirthDate, formatter);

        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.print("Enter order data: ");
        String orderStatus = sc.nextLine();

        OrderStatus status = OrderStatus.valueOf(orderStatus);

        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantityItems = sc.nextInt();

            Product product = new Product(productName, productPrice);
            Item item = new Item(quantityItems, product);

            order.addItem(item);
        }

        System.out.println("ORDER SUMMARY:");
        System.out.println(order.toString());
    }
}
