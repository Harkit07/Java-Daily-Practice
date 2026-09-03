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
        if (n == 0 || n == 1) {
            return n;
        }
        f[n] = fabMemo(n - 1, f) + fabMemo(n - 2, f);
        return f[n];
    }

    // Fabonacci - Tabulation
    public static int fabTab(int n) {
        int f[] = new int[n + 1];
        f[1] = 1;
        for (int i = 1; i < f.length; i++) {
            if (i == 1) {
                f[i] = f[i] + 0;
            } else {
                f[i] = f[i - 1] + f[i - 2];
            }
        }
        return f[n];
    }

    // Climbing Stairs - Recursion

    // Climbing Stairs - Mimoization

    // Climbing Stairs - Tabulation

    public static void main(String[] args) {
        // Fabonacci - Recursion
        int n = 8;
        System.out.println(fab(5));
        System.out.println(fab(n));

        // Fabonacci - Mimoization
        int f[] = new int[n + 1];
        System.out.println(fabMemo(n, f));

        // Fabonacci - Tabulation
        System.out.println(fabTab(5));
        System.out.println(fabTab(8));

        // Climbing Stairs - Recursion

        // Climbing Stairs - Mimoization

        // Climbing Stairs - Tabulation
    }
}
