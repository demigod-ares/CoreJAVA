// Subject interface
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }
    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }
    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class Proxy7 {
    public static void main(String[] args) {
        // Using Proxy to control access to RealSubject
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");
        // The RealSubject is only loaded when display is called
        image1.display();
        // The RealSubject is already loaded, so it won't be loaded again
        image1.display();
        // The RealSubject for image2 is loaded when display is called
        image2.display();
        image2.display(); // not loaded
    }
}
