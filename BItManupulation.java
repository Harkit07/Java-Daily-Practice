public class BItManupulation {

    // public static void oddOrEven(int n) {
    // int bitMask = 1;
    // if ((n & bitMask) == 0) {
    // System.out.println("This is even");
    // return;
    // } else {
    // System.out.println("This is odd");
    // return;
    // }
    // }

    public static void oddOrEven(int n) {
        String result = ((n & 1) == 0) ? "Even" : "Odd";
        System.out.println("This is" + result);
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static void main(String[] args) {
        // System.out.println((~15));
        // oddOrEven(8);
        // oddOrEven(9);
        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        System.out.println(clearIthBit(6, 1));
    }
}
