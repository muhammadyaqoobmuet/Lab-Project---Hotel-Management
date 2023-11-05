package src;

public class Reservation {


    private int reservationID;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(int reservationID, Guest guest, Room room, String checkInDate, String checkOutDate) {
        this.reservationID = reservationID;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationID() {
        return reservationID;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationID + "\nGuest Name: " + guest.getFirstName() + " " + guest.getLastName() +
                "\nRoom: " + room.getRoomNumber() + "\nCheck-in Date: " + checkInDate + "\nCheck-out Date: " + checkOutDate;
    }
}
