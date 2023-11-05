package src;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private String location;
    private ArrayList<Room> rooms;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void listAvailableRooms() {
        System.out.println("Available rooms at " + name + ":");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println("Room " + room.getRoomNumber() + " - " + room.getType() + " - $" + room.getPrice() + " per night");
            }
        }
    }

    public Room findAvailableRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isOccupied()) {
                return room;
            }
        }
        return null;
    }

    public boolean bookRoom(int roomNumber, Guest guest, String checkInDate, String checkOutDate) {
        Room room = findAvailableRoom(roomNumber);
        if (room != null) {
            room.bookRoom(guest, checkInDate, checkOutDate);
            return true;
        }
        return false;
    }

    public void checkoutRoom(int roomNumber) {
        Room room = findAvailableRoom(roomNumber);
        if (room != null) {
            room.checkoutRoom();
            System.out.println("Room " + roomNumber + " has been checked out.");
        } else {
            System.out.println("Room " + roomNumber + " is not found or already checked out.");
        }
    }
}
