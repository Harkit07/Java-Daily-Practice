import java.util.Arrays;

public class DP1 {
    // Fabonacci - Recursion
    public static int fab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fab(n - 1) + fab(n - 2);
    }

    // Fabonacci - Mimoization
    public static int fabMemo(int n, int f[]) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != -1) {
            return f[n];
        }
        f[n] = fabMemo(n - 1, f) + fabMemo(n - 2, f);
        return f[n];
    }

    // Fabonacci - Tabulation
    public static int fabTab(int n) {
        if (n == 0)
            return 0;
        int f[] = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    // Climbing Stairs - Recursion
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // Climbing Stairs - Mimoization
    public static int countWaysMemo(int n, int ways[]) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWaysMemo(n - 1, ways) + countWaysMemo(n - 2, ways);
        return ways[n];
    }

    // Climbing Stairs - Tabulation
    public static int countWaysTab(int n) {
        if (n == 0)
            return 1;
        int ways[] = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i < ways.length; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }

    public static void main(String[] args) {
        // Fabonacci - Recursion
        int n = 8;
        System.out.println(fab(5));
        System.out.println(fab(n));

        // Fabonacci - Mimoization
        int f[] = new int[n + 1];
        Arrays.fill(f, -1);
        System.out.println(fabMemo(n, f));

        // Fabonacci - Tabulation
        System.out.println(fabTab(5));
        System.out.println(fabTab(8));

        // Climbing Stairs - Recursion
        System.out.println(countWays(n));

        // Climbing Stairs - Mimoization
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWaysMemo(n, ways));

        // Climbing Stairs - Tabulation
        System.out.println(countWaysTab(n));
    }
}
