public class Recursion {

    // print number from n to 1 (Decreasing Order)
    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    // print number from 1 to n (Increasing Order)
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");

    }

    // print factorial of a number n
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // print sum of first n natural number
    public static int printSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + printSum(n - 1);
    }

    // print Nth fabanacci Number
    public static int fab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fab(n - 1) + fab(n - 2);
    }

    // check if a given array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // WAF to find the first occurance of an element in an array
    public static int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, key, i + 1);
    }

    // WAF to find the last occurance of an element in an array
    public static int lastOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    // Print x^n
    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    // Print x^n(Optimized)
    public static int powOptimized(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPow = powOptimized(x, n / 2);
        int halfPowSq = halfPow * halfPow;

        if (n % 2 != 0) {
            halfPowSq *= x;
        }
        return halfPowSq;
    }

    // Tilling Problem
    public static int tillingProblem(int n) {
        if (n == 1) {
            return 1;
        }
        return tillingProblem(n - 1) + tillingProblem(n - 1);
    }

    // Remove Duplicate in a String
    public static void removeDuplicate(String str, StringBuilder newStr, int i, boolean map[]) {
        if (i == str.length()) {
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(i);
        if (map[ch - 'a'] == true) {
            removeDuplicate(str, newStr, i + 1, map);
        } else {
            map[ch - 'a'] = true;
            removeDuplicate(str, newStr.append(ch), i + 1, map);
        }
    }

    // Friend Pairing problem
    public static int friendPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return friendPairing(n - 1) + (n - 1) * friendPairing(n - 2);
    }

    // Binary String problem
    public static void printBinString(int n, int lastPlace, StringBuilder str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinString(n - 1, 0, str.append(0));
        str.deleteCharAt(str.length() - 1);
        if (lastPlace == 0) {
            printBinString(n - 1, 1, str.append(1));
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        // printDec(5);
        // System.out.println();
        // printInc(5);
        // System.out.println(fact(5));
        // System.out.println(printSum(5));
        // System.out.println(fab(5));
        // int arr[] = { 1, 2, 3, 7, 5, 7 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurance(arr, 4, 0));
        // System.out.println(firstOccurance(arr, 3, 0));
        // System.out.println(lastOccurance(arr, 7, 0));
        // System.out.println(pow(2, 4));
        // System.out.println(powOptimized(2, 10));
        // System.out.println(tillingProblem(4));
        // removeDuplicate("apnacollege", new StringBuilder(""), 0, new boolean[26]);
        // System.out.println(friendPairing(4));
        printBinString(3, 0, new StringBuilder(""));

    }
}
