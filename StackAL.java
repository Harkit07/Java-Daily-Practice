import java.util.ArrayList;

public class StackAL {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(int data) {
        list.add(data);
        return;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack in Empty");
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack in Empty");
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        StackAL s = new StackAL();
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
