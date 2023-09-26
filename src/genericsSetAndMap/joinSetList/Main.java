package genericsSetAndMap.joinSetList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> languages = new TreeSet<>(Arrays.asList("Java", "C#", "Swift", "Javascript", "Javascript")); // Ordena os items é o mais lento.
        System.out.println(languages);

        Set<String> products = new HashSet<>(Arrays.asList("Tv", "Tablet", "Notebook")); // mais rapido
        System.out.println(products);

        Set<String> teams = new LinkedHashSet<>(Arrays.asList("Santos", "Real Madrid")); // velocidade intermediara
        System.out.println(teams);

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        // Union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        // Intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        // Diff
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    }
}
