
import java.util.Stack;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class TextEditor {

    Node head;

    Stack<Character> undoStack = new Stack<>();
    Stack<Character> redoStack = new Stack<>();

    
    void insert(char ch) {
        Node newNode = new Node(ch);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        undoStack.push(ch);
        redoStack.clear();
    }

    
    void delete() {
        if (head == null) {
            System.out.println("Text is empty!");
            return;
        }

        Node temp = head;

        if (head.next == null) {
            undoStack.push(head.data);
            head = null;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }

            undoStack.push(temp.next.data);
            temp.next = null;
        }

        redoStack.clear();
    }

    
    void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        char ch = undoStack.pop();

        deleteLastNode();
        redoStack.push(ch);
    }

    
    void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }

        char ch = redoStack.pop();

        addLastNode(ch);
        undoStack.push(ch);
    }

    
    void deleteLastNode() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    
    void addLastNode(char ch) {
        Node newNode = new Node(ch);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }


    void display() {
        Node temp = head;

        System.out.print("Text: ");

        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.insert('H');
        editor.insert('E');
        editor.insert('L');
        editor.insert('L');
        editor.insert('O');

        editor.display();

        editor.undo();
        System.out.println("After Undo:");
        editor.display();

        editor.redo();
        System.out.println("After Redo:");
        editor.display();

        editor.delete();
        System.out.println("After Delete:");
        editor.display();

        editor.undo();
        System.out.println("After Undo Delete:");
        editor.display();
    }
}
