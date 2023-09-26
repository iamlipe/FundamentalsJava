package genericsSetAndMap.copyAndPrintList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> myIntegers = Arrays.asList(1, 2, 4, 7);
        List<Double> myDoubles = Arrays.asList(3.14, 5.90);
        List<Object> myObjects = new ArrayList<>();

        copy(myIntegers, myObjects);
        print(myObjects);
        myObjects = new ArrayList<>();

        copy(myDoubles, myObjects);
        print(myObjects);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        destiny.addAll(source);
    }

    public static void print(List<?> items) {
        for (Object obj : items) {
            System.out.print(obj + " ");
        }

        System.out.println();
    }
}
