public class DP2 {
    // 0-1 Knapsack - Recursion
    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1), knapsack(val, wt, W, n - 1));
        } else {
            return knapsack(val, wt, W, n - 1);
        }
    }

    // 0-1 Knapsack - Memoization
    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(val[n - 1] + knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp),
                    knapsackMemo(val, wt, W, n - 1, dp));
            return dp[n][W];
        } else {
            dp[n][W] = knapsackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    // 0-1 Knapsack - Tabulation
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    // Target Sum Subset - Tabulation
    public static boolean targetSum(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j && dp[i - 1][j - arr[i - 1]] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    // Unbounded Knapsack - Tabulation
    public static int unboundedKnapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        // 0-1 Knapsack - Recursion
        int val1[] = { 15, 14, 10, 45, 30 };
        int wt1[] = { 2, 5, 1, 3, 4 };
        int W1 = 7;
        System.out.println(knapsack(val1, wt1, W1, val1.length));

        // 0-1 Knapsack - Memoization
        int dp[][] = new int[val1.length + 1][W1 + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        System.out.println(knapsackMemo(val1, wt1, W1, val1.length, dp));

        // 0-1 Knapsack - Tabulation
        System.out.println(knapsackTab(val1, wt1, W1));

        // Target Sum Subset - Tabulation
        int numbers[] = { 4, 2, 7, 1, 3 };
        int sum = 10; // Target Sum
        System.out.println(targetSum(numbers, sum));

        // Unbounded Knapsack - Tabulation
        int val2[] = { 15, 14, 10, 45, 30 };
        int wt2[] = { 2, 5, 1, 3, 4 };
        int W2 = 7;
        System.out.println(unboundedKnapsackTab(val2, wt2, W2));
    }
}
