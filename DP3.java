public class DP3 {
    // Coin Change - Tabulation
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    // Rod Cutting - Tabulation
    public static int rodCutting(int length[], int price[], int rodLength) {
        int n = length.length;
        int dp[][] = new int[n + 1][rodLength + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i - 1][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][rodLength];
    }

    // Longest Common Subsequence - Recursion
    public static int lcsRec(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcsRec(str1, str2, n - 1, m - 1) + 1;
        } else {
            return Math.max(lcsRec(str1, str2, n - 1, m), lcsRec(str1, str2, n, m - 1));
        }
    }

    // Longest Common Subsequence - Memoization
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcsMemo(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            return dp[n][m] = Math.max(lcsMemo(str1, str2, n - 1, m, dp), lcsMemo(str1, str2, n, m - 1, dp));
        }
    }

    // Longest Common Subsequence - Tabulation
    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        // Coin Change - Tabulation
        int coins[] = { 2, 3, 5, 6 };
        int sum = 10;
        System.out.println(coinChange(coins, sum));

        // Rod Cutting - Tabulation
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength));

        // Longest Common Subsequence - Recursion
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();
        System.out.println(lcsRec(str1, str2, n, m));

        // Longest Common Subsequence - Memoization
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcsMemo(str1, str2, n, m, dp));

        // Longest Common Subsequence - Tabulation
        System.out.println(lcsTab(str1, str2));

    }
}
