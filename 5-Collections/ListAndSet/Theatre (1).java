package ListAndSet;

import java.util.*;

public class Theatre {
    private final String theatreName;
    // private List<Seat> seats = new ArrayList<>();
    // private Set<Seat> seats = new HashSet<>();
    private Set<Seat> seats = new LinkedHashSet<>();
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }
    public String getTheatreName() {
        return theatreName;
    }
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = this.findSeat(seatNumber);
        if(requestedSeat == null) return false;
        return requestedSeat.reserve();
    }
    public boolean cancelSeat(String seatNumber) {
        Seat requestedSeat = this.findSeat(seatNumber);
        if(requestedSeat == null) return false;
        return requestedSeat.cancel();
    }
    private Seat findSeat(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return null;
    }
    // for testing
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    // ===============================Seat (Private Inner) Class==============================

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;
        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is already reserved");
                return false;
            }
        }
        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is not reserved yet");
                return false;
            }
        }
        public String getSeatNumber() {
            return seatNumber;
        }
    }

}
