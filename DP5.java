public class DP5 {
    // Wildlcard Matching - Tabulation
    public static boolean wildcardMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // Catalan Number - Recursion

    // Catalan Number - Memoization

    // Catalan Number - Tabulation

    // Count BST's - Tabulation

    // Mountain Ranges - Tabulation

    public static void main(String[] args) {
        // Wildlcard Matching - Tabulation
        String text1 = "baaabab";
        String pattern1 = "*****ba*****ab"; // true
        System.out.println(wildcardMatching(text1, pattern1));

        String text2 = "baaabab";
        String pattern2 = "a*ab"; // false
        System.out.println(wildcardMatching(text2, pattern2));

        // Catalan Number - Recursion
        int n = 4;

        // Catalan Number - Memoization

        // Catalan Number - Tabulation

        // Count BST's - Tabulation
        int node1 = 3; // int nodes[]={10, 20, 30};
        // ans = 5;

        int node2 = 4; // int nodes[]={10, 20, 30, 40};
        // ans = 14;

        // Mountain Ranges - Tabulation
        int pair1 = 2;
        int pair2 = 3;
    }
}
