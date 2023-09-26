package exceptions.checkInHotel;

import exceptions.checkInHotel.model.entities.Reservation;
import exceptions.checkInHotel.model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("Check-in data (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), formatter);

            System.out.print("Check-out data (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), formatter);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation: ");

            System.out.print("Check-in data (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), formatter);

            System.out.print("Check-out data (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), formatter);

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
