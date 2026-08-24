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
            System.out.print("C=" + pq.remove().idx + "  ");
        }
        System.out.println();
    }

    // Connect N Ropes
    public static int connectNRopes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += (min1 + min2);
            pq.add(min1 + min2);
        }
        return cost;
    }

    // Weakest Soldiers
    static class Rows implements Comparable<Rows> {
        int sol;
        int idx;

        public Rows(int sol, int idx) {
            this.sol = sol;
            this.idx = idx;
        }

        @Override
        public int compareTo(Rows r2) {
            if (this.sol == r2.sol) {
                return this.idx - r2.idx;
            } else {
                return this.sol - r2.sol;
            }
        }
    }

    public static void weakestSoilders(int army[][], int k) {
        PriorityQueue<Rows> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Rows(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.print("R=" + pq.remove().idx + "  ");
        }
        System.out.println();
    }

    // Sliding Window Maximum
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // descending order
            return p2.val - this.val;
        }

    }

    public static void maxSildingWindows(int arr[], int k) {
        int res[] = new int[arr.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;
        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

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
        int ropes[] = { 2, 3, 3, 4, 6 };
        System.out.println(connectNRopes(ropes));

        // Weakest Soldiers
        int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int n = 2;
        weakestSoilders(army, n);

        // Sliding Window Maximum
        int num[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int w = 3;
        maxSildingWindows(num, w);
    }
}
