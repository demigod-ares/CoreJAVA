import java.util.ArrayList;
import java.util.List;

// Step 1: Observer interface
interface Observer {
    void update(String news);
}

// Step 2: Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String news);
}

// Step 3: ConcreteObserver class
// Registers interest in changes to the subject and receives notifications.
class NewsOutlet implements Observer {
    private String name;
    public NewsOutlet(String name) {
        this.name = name;
    }
    @Override
    public void update(String news) {
        System.out.println(name + " outlet received news: " + news);
    }
}

// Step 4: ConcreteSubject class
// Maintains a list of observers.
// Provides methods to attach, detach, and notify observers of state changes.
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
    public void setLatestNews(String latestNews) {
        this.latestNews = latestNews;
        notifyObservers(this.latestNews);
    }
}

// Step 5: Client code
public class Observer8 {
    public static void main(String[] args) {
        // Create news outlets (observers)
        NewsOutlet outlet1 = new NewsOutlet("Outlet 1");
        NewsOutlet outlet2 = new NewsOutlet("Outlet 2");
        NewsOutlet outlet3 = new NewsOutlet("Outlet 3");

        // Create a news agency (subject) and register observers
        NewsAgency newsAgency = new NewsAgency();
        newsAgency.addObserver(outlet1);
        newsAgency.addObserver(outlet2);
        newsAgency.addObserver(outlet3);

        // Set latest news (notify observers)
        newsAgency.setLatestNews("Breaking News: Observer Pattern Explained");
    }
}
