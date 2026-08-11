// import java.util.LinkedList;

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
    public static Node reverse(Node head) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return null;
        } else {
            Node prev = null;
            Node curr = tail = head;
            Node next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    // Find and remove Nth node form end (Iterative approach)
    public static Node deleteNthFromEnd(Node head, int idx) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        if (idx <= 0 || idx > sz) {
            System.out.println("Invalid index");
            return head;
        }

        if (idx == sz) {
            return head.next;
        }
        int i = 1;
        Node prev = head;
        while (i < sz - idx) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    // Check if LL is a Palindrone
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // LinkedList<Integer> LL = new LinkedList<>();
        // LL.addFirst(3);
        // LL.addFirst(2);
        // LL.addFirst(1);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // printLL(head);
        // head = reverse(head);
        printLL(head);
        head = deleteNthFromEnd(head, 2);
        printLL(head);
    }
}
