public class BuildST {
    static int tree[];

    // Init Build Segmant Tree
    public static void init(int n) {
        tree = new int[n * 4];
    }

    // Contruct Segment Tree
    public static int buildTree(int arr[], int i, int start, int end) {
        if (start == end) {
            return tree[i] = arr[start];
        }
        int mid = start + (end - start) / 2;
        buildTree(arr, 2 * i + 1, start, mid);
        buildTree(arr, 2 * i + 2, mid + 1, end);
        return tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    // Query Segment Tree - Sum
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        if (qi > sj || qj < si) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = si + (sj - si) / 2;
            int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
            int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;

        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // Query Segment Tree - Update
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) {
            return;
        }
        tree[i] += diff;
        if (si != sj) {
            int mid = si + (sj - si) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff);
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }

    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n - 1, idx, diff);
    }

    // Max/Min Element Queries - Build
    public static void buildMaxTree(int arr[], int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildMaxTree(arr, 2 * i + 1, start, mid);
        buildMaxTree(arr, 2 * i + 2, mid + 1, end);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Max/Min Element Queries - Get
    public static int getMaxUtil(int arr[], int i, int si, int sj, int qi, int qj) {
        if (qi > sj || qj < si) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = si + (sj - si) / 2;
            int left = getMaxUtil(arr, 2 * i + 1, si, mid, qi, qj);
            int right = getMaxUtil(arr, 2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;

        return getMaxUtil(arr, 0, 0, n - 1, qi, qj);
    }

    // Max/Min Element Queries - Update
    public static void updateMaxUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }
        if (si == sj) {
            tree[i] = newVal;
            return;
        }
        int mid = si + (sj - si) / 2;
        updateMaxUtil(2 * i + 1, si, mid, idx, newVal);
        updateMaxUtil(2 * i + 2, mid + 1, sj, idx, newVal);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void updateMax(int arr[], int idx, int newVal) {
        int n = arr.length;
        arr[idx] = newVal;

        updateMaxUtil(0, 0, n - 1, idx, newVal);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // Init Build Segmant Tree
        int n = arr.length;
        init(n);

        // Contruct Segment Tree
        buildTree(arr, 0, 0, n - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + "  ");
        }

        // Query Segment Tree - Sum
        System.out.println(getSum(arr, 2, 5));

        // Query Segment Tree - Update
        System.out.println(getSum(arr, 2, 5));
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));

        // Max/Min Element Queries - Build
        int arr2[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n1 = arr2.length;
        init(n1);
        buildMaxTree(arr2, 0, 0, n1 - 1);

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + "  ");
        }

        // Max/Min Element Queries - Get
        System.out.println(getMax(arr2, 2, 5));

        // Max/Min Element Queries - Update
        updateMax(arr2, 2, 5);
        System.out.println(getMax(arr2, 2, 5));

    }
}
