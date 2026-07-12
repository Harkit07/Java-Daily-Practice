public class Recursion1 {

    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int calcSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calcSum(n - 1);
    }

    public static int printNFab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return printNFab(n - 1) + printNFab(n - 2);
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, key, i + 1);
    }

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

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    public static int optimizedPow(int x, int n){
        if(n==0){
            return 1;
        }
        int halfPow= optimizedPow(x, n/2);
        int halfPowSq = halfPow*halfPow;
        if(n%2!=0){
            halfPowSq= n * halfPowSq;
        }
        return halfPowSq;
    }
                                                                                                     
    public static void main(String[] args) {
        // printDec(5);
        // printInc(5);
        // System.out.println(printNFab(8));
        // int arr[] = { 1, 2, 3, 9, 5, 9 };
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurance(arr, 3, 0));
        // System.out.println(lastOccurance(arr, 9, 0));
        System.out.println(pow(2, 4));
    }
}
