public class CircularQueueArr {
    static class Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
                arr[front] = data;
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                return -1;
            }
            int top = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
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
