public class StrQuestion {

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'N') {
                y++;
            } else if (ch == 'E') {
                x++;
            } else if (ch == 'W') {
                x--;
            } else {
                y--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static void largestString(String str[]) {
        String largest = str[0];
        for (int i = 1; i < str.length; i++) {
            if (largest.compareTo(str[i]) < 0) {
                largest = str[i];
            }
        }
        System.out.println(largest);
    }

    public static String strUpperCase(String str) {
        StringBuilder newStr = new StringBuilder("");
        newStr.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == ' ') {
                newStr.append(str.charAt(i));
                i++;
                newStr.append(Character.toUpperCase(str.charAt(i)));
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    public static String stringCompression(String str) {
        StringBuilder newStr = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if (count > 1) {
                newStr.append(count);
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        // String str = "racecar";
        // System.out.println(isPalindrome(str));
        // String Str = "WNEENESENNN";
        // System.out.println(shortestPath(Str));
        // String fruits[] = { "apple", "mango", "banana" };
        // largestString(fruits);
        // String str = "hi, i am shardha";
        // System.out.println(strUpperCase(str));
        String str = "aaabbcccdd";
        System.out.println(stringCompression(str));
    }
}
