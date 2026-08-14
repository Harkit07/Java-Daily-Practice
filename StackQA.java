import java.util.Stack;

public class StackQA {

    // Push at the bottom of the Stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Reverse a String using Stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            s.push(ch);
        }

        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            char ch = s.pop();
            sb.append(ch);
        }
        return sb.toString();
    }

    // Reverse a Stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // Stocks span problem
    public static void stocksSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int curr = stocks[i];
            while (!s.isEmpty() && curr >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }

    // Next Greater Element
    public static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }

    // Print Stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(1);
        s.push(3);
        // printStack(s);
        // pushAtBottom(s, 4);
        // printStack(s);
        // String str = "hello";
        // System.out.println(reverseString(str));
        // reverseStack(s);
        // printStack(s);
        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stocksSpan(stocks, span);
        int arr[] = { 6, 8, 0, 1, 3 };
        nextGreater(arr);
    }
}
