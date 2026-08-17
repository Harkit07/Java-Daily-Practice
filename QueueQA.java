import java.util.LinkedList;
import java.util.Queue;

public class QueueQA {
    // Stack using 2 Queue
    // static class Stack {
    // static Queue<Integer> q1 = new LinkedList<>();
    // static Queue<Integer> q2 = new LinkedList<>();

    // public boolean isEmpty() {
    // return q1.isEmpty() && q2.isEmpty();
    // }

    // public void add(int data) {
    // if (!q1.isEmpty()) {
    // q1.add(data);
    // } else {
    // q2.add(data);
    // }
    // }

    // public int remove() {
    // if (isEmpty()) {
    // return -1;
    // }
    // if (!q1.isEmpty()) {
    // while (q1.size() > 1) {
    // q2.add(q1.remove());
    // }
    // return q1.remove();
    // } else {
    // while (q2.size() > 1) {
    // q1.add(q2.remove());
    // }
    // return q2.remove();
    // }
    // }

    // public int peek() {
    // if (isEmpty()) {
    // return -1;
    // }
    // int top = -1;
    // if (!q1.isEmpty()) {
    // while (q1.size() > 1) {
    // q2.add(q1.remove());
    // }
    // top = q1.remove();
    // q1.add(top);
    // } else {
    // while (q2.size() > 1) {
    // q1.add(q2.remove());
    // }
    // top = q2.remove();
    // q1.add(top);
    // }
    // return top;
    // }
    // }

    // First non-repeating latter in a stream of character

    // Interleaves 2 halves of a Queue(Even length)

    // Queue Reversal

    public static void main(String[] args) {
        // Stack s = new Stack();
        // s.add(3);
        // s.add(2);
        // s.add(1);
        // while (!s.isEmpty()) {
        // System.out.print(s.peek() + " ");
        // s.remove();
        // }
        // System.out.println();

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
