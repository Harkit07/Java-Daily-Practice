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
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Print LinkList
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add in middle - add
    public void add(int data, int idx) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Size of LinkList
    public int size() {
        return size;
    }

    // Remove in LinkList = removeFirst
    public int removeFirst() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else {
            int val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return val;
        }
    }

    // Remove in LinkList = removeLast
    public int removeLast() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        } else {
            int i = 1;
            Node temp = head;
            while (i < size - 1) {
                temp = temp.next;
                i++;
            }
            int val = temp.next.data;
            temp.next = null;
            tail = temp;
            size--;
            return val;
        }
    }

    // Search in LinkList - Iterative
    public int itrSearch(int key) {
        if (head == null) {
            return -1;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Search in LinkList - Recursive
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(7);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(9);
        ll.printLL();
        // System.out.println(ll.size());
        ll.removeFirst();
        ll.removeLast();
        ll.printLL();
        System.out.println(ll.itrSearch(3));
        System.out.println(ll.itrSearch(5));
        System.out.println(ll.itrSearch(11));

    }
}
