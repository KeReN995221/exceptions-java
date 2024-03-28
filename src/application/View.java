package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entites.Reservation;

public class View {

    public static void main(String[] args) throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = keyboard.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(keyboard.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(keyboard.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(keyboard.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(keyboard.next());
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Erro in reservation, because the dates for reservaton must be in the future");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Erro in reservation, because the dates for reservaton must be in the future 2");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

        }
        keyboard.close();

    }

}
