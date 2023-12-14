import java.util.ArrayList;
import java.util.List;

// Step 1: Mediator interface
interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user1);
}
// Step 2: ConcreteMediator class
class ChatMediatorImpl implements ChatMediator {
    @Override
    public void sendMessage(String message, User sender) {
        // Broadcast the message to all users except the sender
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
    private List<User> users = new ArrayList<>();
    public void addUser(User user) {
        users.add(user);
    }
}

// Step 3: Colleague interface
interface User {
    void sendMessage(String message);
    void receiveMessage(String message);
}
// Step 4: ConcreteColleague class
class ChatUser implements User {
    private String name;
    private ChatMediator mediator;
    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends message: " + message);
        mediator.sendMessage(message, this);
    }
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " receives message: " + message);
    }
}

// Step 5: Client code
public class Mediator6 {
    public static void main(String[] args) {
        // Create a chat mediator
        ChatMediator mediator = new ChatMediatorImpl();
        ChatMediator mediator2 = new ChatMediatorImpl();

        // Create users and add them to the chat mediator
        User user1 = new ChatUser("User 1", mediator);
        User user2 = new ChatUser("User 2", mediator);
        User user3 = new ChatUser("User 3", mediator);
        User user4 = new ChatUser("User 4", mediator2); // 2nd argument should be array of mediators
        User user5 = new ChatUser("User 5", mediator2);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator2.addUser(user3);
        mediator2.addUser(user4);
        mediator2.addUser(user5);

        // Users send and receive messages through the mediator
        user2.sendMessage("Hi there!");
        user3.sendMessage("User 3");
        user5.sendMessage("I am Groot!");
    }
}
