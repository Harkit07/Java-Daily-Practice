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

    // Detect a Loop/Cycle in a LL
    public static boolean isCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Remove a Loop/Cycle in a LL
    public static void removeCycle(Node head) {
        if (head == null || head.next == null) {
            System.out.println("No Cycle Exists");
            return;
        }

        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            System.out.println("No Cycle Exists");
            return;
        }

        // Special case: cycle starts at head
        if (slow == head) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // Merge Sort in a LL
    public static Node getMid(Node head) {
        if (head == null)
            return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        temp.next = (head1 != null) ? head1 : head2; // attach whatever remains
        return mergeLL.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // base case
        }
        Node midNode = getMid(head);
        Node left = head;
        Node right = midNode.next;
        midNode.next = null;
        Node newLeft = mergeSort(left);
        Node newRight = mergeSort(right);
        return merge(newLeft, newRight);
    }

    // Zig-Zag in a LL
    public void zigZag(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node curr = mid;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        // LinkedList<Integer> LL = new LinkedList<>();
        // LL.addFirst(3);
        // LL.addFirst(2);
        // LL.addFirst(1);

        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);

        // printLL(head);
        // head = reverse(head);
        // printLL(head);
        // head = deleteNthFromEnd(head, 2);
        // printLL(head);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = head2.next; // node 3 -> node 2 (cycle)
        // System.out.println("Test 2 (cycle to middle): " + isCycle(head2));
        // removeCycle(head2);
        // printLL(head2);
    }
}
