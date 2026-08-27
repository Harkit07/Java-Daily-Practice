import java.util.HashSet;
// import java.util.LinkedHashSet;
// import java.util.TreeSet;

public class HashSetQA {
    // Count Distinct Element
    public static int countDistinctEl(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }

    // Union and Intersection
    public static void unionAndIntersection(int arr1[], int arr2[]) {

    }

    public static void main(String[] args) {
        // HashSet<String> hs = new HashSet<>();
        // hs.add("India");
        // hs.add("China");
        // hs.add("Srilanka");
        // hs.add("Pakistan");

        // for (String data : hs) {
        // System.out.print(data + " ");
        // }
        // System.out.println();
        // // Order is unpredictable, e.g.: Srilanka Pakistan China India

        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("India");
        // lhs.add("China");
        // lhs.add("Srilanka");
        // lhs.add("Pakistan");

        // for (String data : lhs) {
        // System.out.print(data + " ");
        // }
        // System.out.println();
        // // Output: India China Srilanka Pakistan (insertion order preserved)

        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("India");
        // ts.add("China");
        // ts.add("Srilanka");
        // ts.add("Pakistan");

        // for (String data : ts) {
        // System.out.print(data + " ");
        // }
        // System.out.println();
        // // Output: China India Pakistan Srilanka (alphabetical order)

        // Count Distinct Element
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        System.out.println(countDistinctEl(num));

        // Union and Intersection
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };

    }
}
