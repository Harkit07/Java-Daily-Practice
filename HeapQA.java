import java.util.PriorityQueue;

public class HeapQA {
    // HeapSort
    private static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < size && arr[minIdx] > arr[left]) {
            minIdx = left;
        }
        if (right < size && arr[minIdx] > arr[right]) {
            minIdx = right;
        }
        if (minIdx != i) {
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            heapify(arr, minIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    // Nearby cars
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;
        int idx;

        public Point(int x, int y, int dist, int idx) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.dist - p2.dist;
        }
    }

    public static void nearbyCars(int points[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distSq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new Point(points[i][0], points[i][1], distSq, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }

    // Connect N Ropes
    // static class Rope implements Comparable<Rope> {
    // int len;

    // }

    // Weakest Soldiers

    // Weakest Soldiers

    // Sliding Window Maximum

    public static void main(String[] args) {
        // HeapSort
        int arr[] = { 1, 4, 5, 3, 2 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Nearby cars
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, -4 } };
        int k = 2;
        nearbyCars(points, k);

        // Connect N Ropes

        // Weakest Soldiers

        // Sliding Window Maximum

    }
}
