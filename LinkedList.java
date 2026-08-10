public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add in LinkList - addFirst
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }

    // Add in LinkList - addLast

    // Print LinkList

    // Add in middle - add

    // Size of LinkList

    // Remove in LinkList = removeFirst

    // Remove in LinkList = removeLast

    // Search in LinkList - Iterative

    // Search in LinkList - Recursive

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);

    }
}
