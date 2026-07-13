public class Recursion2 {

    public static int tillingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return tillingProblem(n - 1) + tillingProblem(n - 2);
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int friendPairProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return friendPairProblem(n - 1) + (n - 1) * friendPairProblem(n - 2);
    }

    public static void printBinaryString(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinaryString(n - 1, 0, str + 0);
        if (lastPlace == 0) {
            printBinaryString(n - 1, 1, str + 1);
        }
    }

    public static void main(String[] args) {
        // System.out.println(tillingProblem(3));
        // removeDuplicate("apnacollege", 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(friendPairProblem(5));
        printBinaryString(5, 0, "");
    }
}
