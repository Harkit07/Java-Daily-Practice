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

    // Longest Common Subsequence - Recursion

    // Longest Common Subsequence - Memoization

    // Longest Common Subsequence - Tabulation

    public static void main(String[] args) {
        // Coin Change - Tabulation
        int coins[] = { 2, 3, 5, 6 };
        int sum = 10;
        System.out.println(coinChange(coins, sum));

        // Rod Cutting - Tabulation
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;

        // Longest Common Subsequence - Recursion
        String str1 = "abcde";
        String str2 = "ace";

        // Longest Common Subsequence - Memoization

        // Longest Common Subsequence - Tabulation

    }
}
