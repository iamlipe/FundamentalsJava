package enumerationAndComposition.orderingSystem.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumerationAndComposition.orderingSystem.entities.enums.OrderStatus;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private final List<Item> items = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0;

        for (Item i : items) {
            sum += i.subTotal();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        sb.append("Order momemnt: ");
        sb.append(moment.format(formatter));
        sb.append("\n");
        sb.append("Order status: ");
        sb.append(status);
        sb.append("\n");
        sb.append(client.toString());
        sb.append("\n");
        sb.append("Order items:");

        for (Item i : items) {
            sb.append("\n");
            sb.append(i.toString());
        }

        return sb.toString();
    }
}
