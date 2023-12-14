// Step 1: Iterator interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Step 2: ConcreteIterator class
class BookIterator implements Iterator {
    private Book[] books;
    private int currentIndex;
    public BookIterator(Book[] books) {
        this.books = books;
        this.currentIndex = 0;
    }
    public boolean hasNext() {
        return currentIndex < books.length;
    }
    public Object next() {
        if (hasNext()) {
            return books[currentIndex++];
        }
        return null;
    }
}

// Step 3: Aggregate interface
interface Aggregate {
    Iterator createIterator();
}

// Step 4: ConcreteAggregate class
class BookCollection implements Aggregate {
    private Book[] books;
    public BookCollection(Book[] books) {
        this.books = books;
    }
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

// Step 5: Element of the collection
class Book {
    private String title;
    private String author;
    private int year;
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Book: " + this.title + ", Author(s): " + this.author + ", Year: " + this.year;
    }
}

// Step 6: Client code
public class Iterator4 {
    public static void main(String[] args) {
        // Create a collection of books
        Book[] books = {
            new Book("Design Patterns", "Erich Gamma", 1994),
            new Book("Clean Code", "Robert C. Martin", 2008),
            new Book("The Pragmatic Programmer", "Andrew Hunt, David Thomas", 1999)
        };

        // Create a book collection
        BookCollection bookCollection = new BookCollection(books);

        // Use the iterator to traverse the collection
        Iterator iterator = bookCollection.createIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }
}