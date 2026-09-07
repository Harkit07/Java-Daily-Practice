import java.util.Arrays;

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
    public static int catalanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;

        for (int i = 0; i <= n - 1; i++) {
            ans += catalanRec(i) * catalanRec(n - i - 1);
        }
        return ans;
    }

    // Catalan Number - Memoization
    public static int catalanMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    // Catalan Number - Tabulation
    public static int catalanTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    // Count BST's - Tabulation
    public static int countBstTab(int nodes) {
        int dp[] = new int[nodes + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int leftCount = dp[j];
                int rightCount = dp[i - j - 1];
                dp[i] += leftCount * rightCount;
            }
        }
        return dp[nodes];
    }

    // Mountain Ranges - Tabulation
    public static int mountainRangesTab(int pairs) {
        int dp[] = new int[pairs + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int leftPairs = dp[j];
                int rightPairs = dp[i - j - 1];
                dp[i] += leftPairs * rightPairs;
            }
        }
        return dp[pairs];
    }

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
        System.out.println(catalanRec(n));

        // Catalan Number - Memoization
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMemo(n, dp));

        // Catalan Number - Tabulation
        System.out.println(catalanTab(n));

        // Count BST's - Tabulation
        int node1 = 3; // int nodes[]={10, 20, 30};
        // ans = 5;
        System.out.println(countBstTab(node1));

        int node2 = 4; // int nodes[]={10, 20, 30, 40};
        // ans = 14;
        System.out.println(countBstTab(node2));

        // Mountain Ranges - Tabulation
        int pair1 = 2;
        int pair2 = 3;
        System.out.println(mountainRangesTab(pair1));
        System.out.println(mountainRangesTab(pair2));
    }
}
