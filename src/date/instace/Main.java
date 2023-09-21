package date.instace;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        // DATE 2023-09-18
        LocalDate date01 = LocalDate.now();
        System.out.println(date01);

        // DATE 2023-09-18T23:57:32.362928 HORARIO LOCAL
        LocalDateTime date02 = LocalDateTime.now();
        System.out.println(date02);

        // DATE 2023-09-19T02:58:27.101441Z HORARIO GLOBAL
        Instant date03 = Instant.now();
        System.out.println(date03);

        // INSTANCIAR UMA DATA ESPECIFICA
        LocalDate date04 = LocalDate.parse("2023-09-19");
        System.out.println(date04);

        LocalDateTime date05 = LocalDateTime.parse("2023-09-10T01:30:26");
        System.out.println(date05);

        Instant date06 = Instant.parse("2023-09-10T01:30:26Z");
        System.out.println(date06);
        
        // INSTANCIAR UMA DATA COM FORMATTER dd/mm/yyyy
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data08 = LocalDate.parse("19/09/2023", formatter1);
        System.out.println(data08);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date09 = LocalDateTime.parse("19/09/2023 01:30", formatter2);
        System.out.println(date09);

        // INSTANCIAR COM INPUT SEPARADO
        LocalDate Date10 = LocalDate.of(2023, 9, 19);
        System.out.println(Date10);
    }
}
