package genericsSetAndMap.printList.service;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {

    List<T> items = new ArrayList<>();

    public PrintService() {
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T first() {
        if (items.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return items.get(0);
    }

    public void print() {
        System.out.print("[");

        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i));

            if (!(i == items.size() - 1)) {
                System.out.print(", ");
            }
        }

        System.out.print("]");
    }
}
