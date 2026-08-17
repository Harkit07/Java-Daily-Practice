import java.util.Deque;
import java.util.LinkedList;

public class SandQDeque {
    static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void add(int data) {
            dq.addFirst(data);
        }

        public int pop() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.getFirst();
        }
    }

    static class Queue {
        static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();

        Stack s = new Stack();
        s.add(1);
        s.add(2);
        s.add(3);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();
    }
}
