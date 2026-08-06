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

    // print sum of first n natural number

    // print Nth fabanacci Number

    // check if a given array is sorted or not

    // WAF to find the first occurance of an element in an array

    // WAF to find the last occurance of an element in an array

    // Print x^n

    // Print x^n(Optimized)

    // Tilling Problem

    // Remove Duplicate in a String

    // Friend Pairing problem

    // Binary String problem

    public static void main(String[] args) {
        printDec(5);
        System.out.println();
        printInc(5);
    }
}
