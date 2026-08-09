import java.util.ArrayList;
// import java.util.Collections;

public class Arraylist {
    public static void printReverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static int findMax(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }

    public static void swapList(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static int containWaterBruteForce(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    public static int containWater(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        int lp = 0;
        int rp = height.size() - 1;
        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(9);
        // list.add(4);
        // list.add(5);
        // System.out.println(list);
        // System.out.println(list.get(1));
        // list.add(4);
        // list.add(3);
        // list.remove(2);
        // System.out.println(list);
        // System.out.println(list.contains(2));
        // System.out.println(list.contains(6));
        // printReverse(list);
        // System.out.println(findMax(list));
        // swapList(list, 2, 0);
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();
        // for (int i = 1; i <= 5; i++) {
        // list1.add(1 * i);
        // list2.add(2 * i);
        // list3.add(3 * i);
        // }
        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);
        // System.out.println(mainList);
        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        ArrayList<Integer> height = new ArrayList<>();
        for (int h : arr) {
            height.add(h);
        }
        // System.out.println(containWaterBruteForce(height));
        System.out.println(containWater(height));
    }
}
