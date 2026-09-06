public class DP4 {
    // Longest Common Substring - Tabulation
    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    // Longest Increasing Subsequence - Tabulation

    // Edit Distance - Tabulation

    public static void main(String[] args) {
        // Longest Common Substring - Tabulation
        String s1 = "ABCDE";
        String s2 = "ABGCE";
        System.out.println(longestCommonSubstring(s1, s2));

        // Longest Increasing Subsequence - Tabulation
        int arr1[] = { 50, 3, 10, 7, 40, 80 };

        // Edit Distance - Tabulation
        String word1 = "intention";
        String word2 = "execution";
    }
}
