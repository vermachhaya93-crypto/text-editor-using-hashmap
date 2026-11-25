
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

    
    void insert(char ch) {
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

        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }

        System.out.println();
    }
}

public class main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.insert('H');
        editor.insert('E');
        editor.insert('L');
        editor.insert('L');
        editor.insert('O');

        editor.display();
    }
}
