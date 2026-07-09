public class Array {

    public static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void pairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + curr + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void printSubArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    public static int maxSubArraySum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += arr[k];
                }
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    public static int prefixSum(int arr[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < prefix.length; j++) {
                int end = j;
                cs = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                ms = Math.max(ms, cs);
            }
        }
        return ms;
    }

    public static int kadanAlgorithm(int arr[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        return ms;
    }

    public static int trappingRainWater(int height[]) {
        int n = height.length;
        int trappingWater = 0;
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappingWater += waterLevel - height[i];
        }
        return trappingWater;
    }

    public static int buyAndSellStock(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            if (buyPrice < price[i]) {
                int profit = price[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }

    public static boolean checkTwice(int arr[]) {
        boolean freq[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i]] == true) {
                return true;
            } else {
                freq[arr[i]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6 };
        reverseArray(arr);

    }

}
