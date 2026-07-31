public class BinaryNumbers {

    public static void binToDec(int binNum) {
        int pow = 0;
        int decNum = 0;
        int num = binNum;
        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum += lastDigit * Math.pow(2, pow);
            pow++;
            binNum /= 10;
        }
        System.out.println("Binary Number of " + num + " = " + decNum);
    }

    public static void decToBin(int decNum) {
        int pow = 0;
        int myNum = decNum;
        int binNum = 0;
        while (decNum > 0) {
            int rem = decNum % 2;
            binNum += (rem * Math.pow(10, pow));
            pow++;
            decNum /= 2;
        }
        System.out.println("Decimal Number of " + myNum + " = " + binNum);
    }

    public static void main(String[] args) {
        // int binNum = 1000;
        // binToDec(binNum);
        int decNum = 8;
        decToBin(decNum);
    }
}
