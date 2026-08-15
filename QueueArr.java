import java.util.Queue;
import java.util.Stack;

public class QueueArr {
    // static class Queue {
    // static int arr[];
    // static int size;
    // static int rear;

    // Queue(int n) {
    // arr = new int[n];
    // size = n;
    // rear = -1;
    // }

    // public boolean isEmpty() {
    // return rear == -1;
    // }

    // public boolean isFull() {
    // return rear == size - 1;
    // }

    // public void add(int data) {
    // if (isFull()) {
    // System.out.println("Queue is Full");
    // return;
    // }
    // rear += 1;
    // arr[rear] = data;
    // }

    // public int remove() {
    // if (isEmpty()) {
    // return -1;
    // }
    // int front = arr[0];
    // for (int i = 0; i < rear; i++) {
    // arr[i] = arr[i + 1];
    // }
    // rear--;
    // return front;
    // }

    // public int peek() {
    // if (isEmpty()) {
    // return -1;
    // }
    // return arr[0];
    // }
    // }

    // Queue using 2 Stack
    // static class Queue {
    // static Stack<Integer> s1 = new Stack<>();
    // static Stack<Integer> s2 = new Stack<>();

    // public boolean isEmpty() {
    // return s1.isEmpty();
    // }

    // public void add(int data) {
    // if (s1.isEmpty()) {
    // s1.add(data);
    // return;
    // } else {
    // while (!s1.isEmpty()) {
    // s2.push(s1.pop());
    // }
    // s1.push(data);
    // while (!s2.isEmpty()) {
    // s1.push(s2.pop());
    // }
    // }
    // }

    // public int remove() {
    // if (isEmpty()) {
    // return -1;
    // } else {
    // return s1.pop();
    // }
    // }

    // public int peek() {
    // if (isEmpty()) {
    // return -1;
    // } else {
    // return s1.peek();
    // }
    // }
    // }

    public static void main(String[] args) {
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        // System.out.print(q.peek() + " ");
        // q.remove();
        // }
        // System.out.println();
    }
}
