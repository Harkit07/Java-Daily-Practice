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

    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearLastIthBit(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    public static int clearInRange(int n, int j, int i) {
        int a = (~0) << (j + 1);
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static int countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExponentation(int n, int a) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= a;
            }
            a *= a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println((~15));
        // oddOrEven(8);
        // oddOrEven(9);
        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(6, 1));
        // System.out.println(updateIthBit(7, 2, 0));
        // System.out.println(isPowerOf2(8));
        // System.out.println(countSetBit(7));
        // System.out.println(clearLastIthBit(8, 1));
        // System.out.println(clearInRange(255, 5, 2));
        System.out.println(fastExponentation(5, 3));
    }
}
