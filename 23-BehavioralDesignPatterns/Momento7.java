import java.util.ArrayList;
import java.util.List;

// Step 1: Memento class
class EditorMemento {
    private String content;
    public EditorMemento(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}
// Step 2: Originator class
class Editor {
    private String content;
    public void write(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public EditorMemento save() {
        return new EditorMemento(content);
    }
    public void restore(EditorMemento memento) { // undo current changes
        this.content = memento.getContent();
    }
}
// Step 3: Caretaker class
class History {
    private List<EditorMemento> snapshots = new ArrayList<>();
    public void saveSnapshot(EditorMemento snapshot) {
        snapshots.add(snapshot);
    }
    public EditorMemento getSnapshot(int index) {
        return snapshots.get(index);
    }
}

// Step 4: Client code
public class Momento7 {
    public static void main(String[] args) {
        // Create an editor and a history caretaker
        Editor editor = new Editor();
        History history = new History();
        // Write and save snapshots
        editor.write("Version 1");
        history.saveSnapshot(editor.save());
        System.out.println(editor.getContent());
        editor.write("Version 2");
        history.saveSnapshot(editor.save());
        System.out.println(editor.getContent());
        editor.write("Version 3");
        history.saveSnapshot(editor.save());
        System.out.println(editor.getContent());
        // Restore to a previous version
        editor.restore(history.getSnapshot(1));
        // Display the content
        System.out.println("Current Content: " + editor.getContent());
    }
}
