import java.util.ArrayList;

public class HeapIMP {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Add in Heap
        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

    }

    public static void main(String[] args) {

    }

}
