public class DoublyLL {
    static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public int removeLast() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        } else {
            size--;
            int val = tail.data;
            tail = tail.prev;
            tail.next = null;
            return val;
        }
    }

    public static void reverseDll() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        } else {
            Node curr = head;
            Node prev = null;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                curr.prev = next;
                prev = curr;
                curr = next;
            }
            tail = head;
            head = prev;
        }
    }

    public static void main(String[] args) {
        DoublyLL DLL = new DoublyLL();
        DLL.addFirst(2);
        DLL.addFirst(1);
        DLL.addLast(3);
        DLL.addLast(4);
        DLL.printLL();
        DLL.removeLast();
        DLL.printLL();

    }
}
