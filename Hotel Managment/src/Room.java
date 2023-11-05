package src;

public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean occupied;
    private Guest currentGuest;
    private String checkInDate;
    private String checkOutDate;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.occupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Guest getCurrentGuest() {
        return currentGuest;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void bookRoom(Guest guest, String checkInDate, String checkOutDate) {
        if (!occupied) {
            this.occupied = true;
            this.currentGuest = guest;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            System.out.println("Room " + roomNumber + " has been booked by " + guest.getFirstName() + " " + guest.getLastName());
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }

    public void checkoutRoom() {
        if (occupied) {
            System.out.println("Room " + roomNumber + " has been checked out by " + currentGuest.getFirstName() + " " + currentGuest.getLastName());
            this.occupied = false;
            this.currentGuest = null;
            this.checkInDate = null;
            this.checkOutDate = null;
        } else {
            System.out.println("Room " + roomNumber + " is not currently occupied.");
        }
    }
}
