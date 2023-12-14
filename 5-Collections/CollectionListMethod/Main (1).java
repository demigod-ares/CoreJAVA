package CollectionListMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy); // Shallow copy
        seatCopy.get(1).reserve(); // reserve in copy list
        if(theatre.reserveSeat("A02")) { // but also reserved in original list
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }
        Collections.reverse(seatCopy);
        printListCopy(theatre.seats, seatCopy); // original list remains same
        Collections.shuffle(seatCopy);
        printListCopy(theatre.seats, seatCopy); // original list remains same
        Theatre.Seat minSeat = Collections.min(seatCopy); // This works because of Comparable
        Theatre.Seat maxSeat = Collections.max(seatCopy); // This works because of Comparable
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);
        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats); // java.lang.IndexOutOfBoundsException
        // Find the use of collection copy method
    }
    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("======================================================================");
    }
    // Default collection sort is merge sort (faster but memory intensive)
    public static void sortList(List<? extends Theatre.Seat> list) {
        for(int i=0; i<list.size() -1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) >0) {  // This works because of Comparable
                    Collections.swap(list, i, j);
                }
            }
        }
    }
    public static void printListCopy(List<Theatre.Seat> seats, List<Theatre.Seat> copy){
        System.out.println("Printing seatCopy");
        printList(copy);
        System.out.println("Printing theatre.seat");
        printList(seats);
    }
}
