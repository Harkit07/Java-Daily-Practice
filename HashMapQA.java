import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashMapQA {

    public static void main(String[] args) {
        // LinkedHashMap (Order of Insertion)
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("Srilanka", 3);
        lhm.put("Pakistan", 20);

        for (String data : lhm.keySet()) {
            System.out.print(lhm.get(data) + " ");
        }
        System.out.println();

        // TreeMap (Ascending Order)
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("Srilanka", 3);
        tm.put("Pakistan", 20);

        for (String data : tm.keySet()) {
            System.out.print(tm.get(data) + " ");
        }
        System.out.println();

    }
}
