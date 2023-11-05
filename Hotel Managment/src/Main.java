package src;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("MUET Hotel by 22SW13", "Sample City");

        // Add initial rooms with room numbers
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(103, "Suite", 250.0));

        while (true) {
            System.out.println("\nHotel Management System -- by 22SW013");
            System.out.println("1. List Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Admin Menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.listAvailableRooms();
                    break;

                case 2:
                    handleUserCheckIn(hotel, scanner);
                    break;

                case 3:
                    handleAdminOperations(hotel, scanner);
                    break;

                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void handleAdminOperations(Hotel hotel, Scanner scanner) {
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.next();

        if (adminPassword.equals("22SW013")) { // Replace with your admin password
            while (true) {
                System.out.println("\nAdmin Menu");
                System.out.println("1. Add Room");
                System.out.println("2. Exit Admin Menu");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter room number: ");
                        int roomNumber = scanner.nextInt();
                        System.out.print("Enter room type (e.g., Single, Double, Suite): ");
                        String roomType = scanner.next();
                        System.out.print("Enter room price: ");
                        double roomPrice = scanner.nextDouble();

                        Room room = new Room(roomNumber, roomType, roomPrice);
                        hotel.addRoom(room);
                        System.out.println("Room added successfully.");
                        break;

                    case 2:
                        System.out.println("Exiting admin menu.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Admin password incorrect. Access denied.");
        }
    }

    private static void handleUserCheckIn(Hotel hotel, Scanner scanner) {
        System.out.print("Enter your first name: ");
        String firstName = scanner.next();
        System.out.print("Enter your last name: ");
        String lastName = scanner.next();
        System.out.print("Enter your email: ");
        String email = scanner.next();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.next();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.next();

        Guest guest = new Guest(firstName, lastName, email);
        hotel.listAvailableRooms();
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();

        if (hotel.bookRoom(roomNumber, guest, checkInDate, checkOutDate)) {
            System.out.println("Room booked successfully.");
        } else {
            System.out.println("Room booking failed. The room is not available or the room number is incorrect.");
        }
    }
}
