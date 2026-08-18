import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithms {
    // Activity Selection
    public static void acitvitySelectiion(int start[], int end[]) {
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> list = new ArrayList<>();
        int maxAct = 1;
        list.add(activities[0][0]);
        int endTime = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= endTime) {
                maxAct++;
                list.add(activities[i][0]);
                endTime = activities[i][2];
            }
        }
        System.out.println("Max Activities = " + maxAct);
        for (int i = 0; i < list.size(); i++) {
            System.out.print("A" + list.get(i) + " ");
        }
        System.out.println();
    }

    // Fractional Knapsack
    public static void fractionalKnapsack(int value[], int weight[], int W) {
        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int totalCost = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                totalCost += value[idx];
                capacity -= weight[idx];
            } else {
                totalCost += (capacity * ratio[i][1]);
                capacity = 0;
            }
        }
        System.out.println("Total Cost = " + totalCost);
    }

    // Min Absulate Difference Pairs
    public static int minAbsPairs(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for (int i = 0; i < B.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        return minDiff;
    }

    // Max Length Chain of Pairs
    public static int maxChainLen(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int endChain = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > endChain) {
                chainLen++;
                endChain = pairs[i][1];
            }
        }
        return chainLen;
    }

    // Indian Coin
    public static void indianCoin(int val) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int countOfCoins = 0;
        int amount = val;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    list.add(coins[i]);
                    countOfCoins++;
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total count of Coins = " + countOfCoins);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    // Job Sequencing Problem

    // Chocola Problem

    public static void main(String[] args) {
        // Activity Selection
        // int start[] = { 10, 12, 20 };
        // int end[] = { 20, 25, 30 };
        // acitvitySelectiion(start, end);

        // Fractional Knapsack
        // int value[] = { 60, 100, 120 };
        // int weight[] = { 10, 20, 30 };
        // int W = 50;
        // fractionalKnapsack(value, weight, W);

        // Min Absulate Difference Pairs
        // int A[] = { 1, 2, 3 };
        // int B[] = { 2, 1, 3 };
        // System.out.println(minAbsPairs(A, B));

        // Max Length Chain of Pairs
        // int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // System.out.println(maxChainLen(pairs));

        // Indian Coin
        int val = 590;
        indianCoin(val);

        // Job Sequencing Problem
        // int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        // Chocola Problem
        // int n = 4, m = 6;
        // Integer costVer[] = { 2, 1, 3, 1, 4 };
        // Integer costHor[] = { 4, 1, 2 };

    }
}
