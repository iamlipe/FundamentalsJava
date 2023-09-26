package genericsSetAndMap.mostExpansiveProduct.service;

import java.util.List;

public class CalculationService {

    public static <T extends Comparable<T>> T max(List<T> items) {
        if (items.isEmpty()) {
            throw new IllegalStateException("List can not be empty");
        }

        T max = items.get(0);

        for (T item : items) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }
}
