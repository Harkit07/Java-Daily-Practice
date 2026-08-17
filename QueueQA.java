import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public static void printNonRepeating(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    // Interleaves 2 halves of a Queue(Even length)
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalves = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalves.add(q.remove());
        }
        while (!firstHalves.isEmpty()) {
            q.add(firstHalves.remove());
            q.add(q.remove());
        }
    }

    // Queue Reversal
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.add(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

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
        q.add(4);
        q.add(5);
        q.add(6);
        // while (!q.isEmpty()) {
        // System.out.print(q.peek() + " ");
        // q.remove();
        // }
        // System.out.println();

        // String str = "aabccxb";
        // printNonRepeating(str);
        // interLeave(q);
        reverse(q);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();

    }
}
