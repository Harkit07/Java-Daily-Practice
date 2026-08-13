public class StackLL {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        StackLL s = new StackLL();
        s.isEmpty();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();

    }
}
