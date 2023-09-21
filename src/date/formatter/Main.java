package date.formatter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        LocalDate date01 = LocalDate.now();
        LocalDateTime date02 = LocalDateTime.now();
        Instant date03 = Instant.now();

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String date11 = formatter1.format(date01);
        System.out.println(date11);

        String date12 = formatter2.format(date02);
        System.out.println(date12);

        System.out.println(date01.format(formatter1));
        System.out.println(date02.format(formatter2));

        // FORMATAR DATA COM HORARIO LOCAL
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        String date13 = formatter3.format(date03);
        System.out.println(date13);
    }
}
