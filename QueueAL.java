public class QueueAL {
    // static class Node {
    //     int data;
    //     Node next;

    //     public Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Queue {
    //     static Node head;
    //     static Node tail;

    //     public boolean isEmpty() {
    //         return head == null;
    //     }

    //     public void add(int data) {
    //         Node newNode = new Node(data);
    //         if (isEmpty()) {
    //             head = tail = newNode;
    //             return;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     public int remove() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int val = head.data;
    //         head = head.next;
    //         return val;
    //     }

    //     public int peek() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    // public static void main(String[] args) {
    //     Queue q = new Queue();
    //     q.add(1);
    //     q.add(2);
    //     q.add(3);
    //     while (!q.isEmpty()) {
    //         System.out.print(q.peek() + " ");
    //         q.remove();
    //     }
    //     System.out.println();
    // }
}
