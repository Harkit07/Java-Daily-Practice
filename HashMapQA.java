// import java.util.LinkedHashMap;
// import java.util.TreeMap;

import java.util.HashMap;
// import java.util.LinkedHashMap;

public class HashMapQA {
    // Majority Element (arr.length/3)
    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : hm.keySet()) {
            if (hm.get(key) > nums.length / 3) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }

    // Valid Anagram
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (hm.get(ch) != null) {
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return hm.isEmpty();
    }

    public static void main(String[] args) {
        // LinkedHashMap (Order of Insertion)
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India", 100);
        // lhm.put("China", 150);
        // lhm.put("Srilanka", 3);
        // lhm.put("Pakistan", 20);

        // for (String data : lhm.keySet()) {
        // System.out.print(lhm.get(data) + " ");
        // }
        // System.out.println();

        // TreeMap (Ascending Order)
        // TreeMap<String, Integer> tm = new TreeMap<>();
        // tm.put("India", 100);
        // tm.put("China", 150);
        // tm.put("Srilanka", 3);
        // tm.put("Pakistan", 20);

        // for (String data : tm.keySet()) {
        // System.out.print(tm.get(data) + " ");
        // }
        // System.out.println();

        // Majority Element
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        majorityElement(nums);

        // Valid Anagram
        String s = "knee";
        String t = "keen";
        System.out.println(isAnagram(s, t));

    }
}
