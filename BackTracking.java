public class BackTracking {
    public static void printSubSet(String str, StringBuilder ans, int i) {
        if (str.length() == i) {
            System.out.println(ans);
            return;
        }
        printSubSet(str, ans.append(str.charAt(i)), i + 1);
        ans.deleteCharAt(ans.length() - 1);
        printSubSet(str, ans, i + 1);
    }

    public static void premutation(String str, StringBuilder ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            premutation(newStr, ans.append(ch));
            ans.deleteCharAt(ans.length() - 1);
        }
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafeQueen(char board[][], int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(char board[][], int rows) {
        if (rows == board.length) {
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafeQueen(board, rows, j)) {
                board[rows][j] = 'Q';
                nQueen(board, rows + 1);
                board[rows][j] = '.';
            }
        }

    }

    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 || j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void main(String[] args) {
        // String str = "abc";
        // printSubSet(str, new StringBuilder(""), 0);
        // premutation(str, new StringBuilder(""));
        // int n = 4;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board.length; j++) {
        // board[i][j] = '.';
        // }
        // }
        // nQueen(board, 0);
        System.out.println(gridWays(0, 0, 4, 4));

    }
}
