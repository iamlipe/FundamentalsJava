package date.manipulate;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        Instant date14 = Instant.now();

        LocalDate r1 = LocalDate.ofInstant(date14, ZoneId.systemDefault());
        System.out.println(r1);

        LocalDate r2 = LocalDate.ofInstant(date14, ZoneId.of("Portugal"));
        System.out.println(r2);

        LocalDateTime r3 = LocalDateTime.ofInstant(date14, ZoneId.systemDefault());
        System.out.println(r3);

        LocalDate date15 = LocalDate.now();
        System.out.println(date15.getDayOfMonth());
        System.out.println(date15.getMonthValue());
        System.out.println(date15.getYear());

        LocalDate date16 = LocalDate.now();

        LocalDate pastWeekLocalDate = date16.minusDays(7);
        System.out.println(pastWeekLocalDate);

        LocalDate nextWeekLocalDate = date16.plusWeeks(1);
        System.out.println(nextWeekLocalDate);

        Instant date17 = Instant.now();

        Instant pastWeekInstant = date17.minus(1, ChronoUnit.WEEKS);
        System.out.println(pastWeekInstant);

        Instant nextWeekInstant = date17.minus(7, ChronoUnit.DAYS);
        System.out.println(nextWeekInstant);

        LocalDateTime date18 = date16.atTime(0, 0);
        System.out.println(date18);

        LocalDateTime date19 = date16.atStartOfDay();
        System.out.println(date19);

        // COMPARAR
        Duration d1 = Duration.between(pastWeekInstant, nextWeekInstant);
        System.out.println(d1.toDays());
        System.out.println(d1.toHours());
    }
}
