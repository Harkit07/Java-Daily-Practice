import java.util.LinkedList;

public class LLQuestions {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;

    // Print LL
    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse a LinkedList

    // Find and remove Nth node form end (Iterative approach)

    // Check if LL is a Palindrone

    public static void main(String[] args) {
        // LinkedList<Integer> LL = new LinkedList<>();
        // LL.addFirst(3);
        // LL.addFirst(2);
        // LL.addFirst(1);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        printLL(head);
    }
}
