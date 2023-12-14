import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListBasic {
    public static void main(String[] args){
        // LinkedList<String> locations = new LinkedList<>(); // OR
        var locations = new LinkedList<String>();
        locations.addAll(List.of("Bombay","Kolkata", "Chennai", "Delhi"));
        System.out.println(locations.get(1) + ": is the item at index 1");
        System.out.println(locations.getFirst() + ": is the first item");
        System.out.println(locations.getLast() + ": is the last item");
        locations.add(2,"Goa");
        locations.add(4,"Goa");
        System.out.println("First occorance of Goa is " + locations.indexOf("Goa"));
        System.out.println("Last occorance of Goa is " + locations.lastIndexOf("Goa"));
        locations.addFirst("Banglore");
        locations.addLast("Pune");
        System.out.println("18 - Linked list Locations: " + locations);
        System.out.println(locations.remove(3) + " was removed");
        System.out.println(locations.remove("Goa") + ": Goa was removed");
        System.out.println("21 - Linked list Locations: " + locations);
        // queue methods
        locations.offer("offer"); // add to last
        locations.offerFirst("offerFirst");
        locations.offerLast("offerLast");
        System.out.println(locations.element() + " is the Firest element"); // returns first element
        System.out.println("29 - Linked list Locations: " + locations);
        // stack methods
        locations.push("push"); // adding at the first
        System.out.println("Peek result is " + locations.peek());
        System.out.println("PeekFirst result is " + locations.peekFirst());
        System.out.println("PeekLast result is " + locations.peekLast());
        System.out.println("35 - Linked list Locations: " + locations);
        System.out.println(locations.pop() + " was removed"); // remove first element

        System.out.println(locations.remove() + " was removed"); // no arguments will remove the first element
        System.out.println(locations.removeFirst() + " was removed"); // same as above
        System.out.println(locations.removeLast() + " was removed");
        System.out.println("41 - Linked list Locations: " + locations);
        System.out.println(locations.poll() + " was removed"); // remove first element
        System.out.println(locations.pollFirst() + " was removed");
        System.out.println(locations.pollLast() + " was removed");

        // Looping : for-each loop creates Internal Iterator here.
        for (String city : locations) System.out.println("Inside loop: " + city);

        // iterator : same as above
        Iterator<String> iterator = locations.iterator();
        do System.out.println("Inside iterator: " + iterator.next());
        while (iterator.hasNext());

        // Removing elements using iterator
        iterator = locations.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("Delhi")) iterator.remove();
            // list.remove() will give ConcurrentModificationException
        }
        System.out.println("59 - Linked list Locations: " + locations);
        
        // ListIterator set() and get() methods
        ListIterator<String> listIterator = locations.listIterator(0);
        while (listIterator.hasNext()){
            if(listIterator.next().equals("Chennai")) listIterator.add("Delhi");
            if(listIterator.next().equals("Pune")) listIterator.set("Goa");
        }
        System.out.println("67 - Linked list Locations: " + locations);

        // moving in reverse direction using list iterator
        while (listIterator.hasPrevious()){
            System.out.println("List Iterator: " + listIterator.previous());
        }
    }
}