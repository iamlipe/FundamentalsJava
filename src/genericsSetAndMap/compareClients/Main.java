package genericsSetAndMap.compareClients;

import genericsSetAndMap.compareClients.entities.Client;

public class Main {

    public static void main(String[] args) {
        Client c1 = new Client("Maria", "maria@gmail.com");
        Client c2 = new Client("Maria", "maria@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2)); // Compara o conteudo do objetos
        System.out.println(c1 == c2); // Compara a referencia na memoria heap
    }
}
