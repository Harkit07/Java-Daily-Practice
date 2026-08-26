// import java.util.ArrayList;
// import java.util.LinkedList;

// public class HashMapIMP {
// static class HashMap<K, V> {// generic
// private class Node {
// K key;
// V value;

// public Node(K key, V value) {
// this.key = key;
// this.value = value;
// }
// }

// private int n;
// private int N;
// private LinkedList<Node> buckets[];

// @SuppressWarnings("unchecked")
// public HashMap() {
// this.N = 4;
// this.buckets = new LinkedList[4];
// for (int i = 0; i < 4; i++) {
// buckets[i] = new LinkedList<>();
// }

// }

// private int hashFunction(K key) {
// int hc = key.hashCode();
// return Math.abs(hc) % N;
// }

// private int searchInLL(K key, int bi) {
// LinkedList<Node> ll = buckets[bi];
// int di = 0;
// for (int i = 0; i < ll.size(); i++) {
// Node data = ll.get(i);
// if (data.key == key) {
// return di;
// }
// di++;
// }
// return -1;
// }

// private void rehash() {
// LinkedList<Node> oldBuct[] = buckets;
// buckets = new LinkedList[N * 2];
// N = N * 2;
// for (int i = 0; i < buckets.length; i++) {
// buckets[i] = new LinkedList<>();
// }
// for (int i = 0; i < oldBuct.length; i++) {
// LinkedList<Node> ll = oldBuct[i];
// for (int j = 0; j < ll.size(); j++) {
// Node curr = ll.remove();
// put(curr.key, curr.value);
// }
// }
// }

// private void put(K key, V value) {
// int bi = hashFunction(key);
// int di = searchInLL(key, bi);
// if (di != -1) {
// Node node = buckets[bi].get(di);
// node.value = value;
// } else {
// buckets[bi].add(new Node(key, value));
// n++;
// }
// double lambda = (double) n / N;
// if (lambda > 2.0) {
// rehash();
// }
// }

// private boolean containsKey(K key) {
// int bi = hashFunction(key);
// int di = searchInLL(key, bi);
// if (di != -1) {
// return true;
// } else {
// return false;
// }
// }

// private V remove(K key) {
// int bi = hashFunction(key);
// int di = searchInLL(key, bi);
// if (di != -1) {
// Node node = buckets[bi].remove(di);
// n--;
// return node.value;
// } else {
// return null;
// }
// }

// private V get(K key) {
// int bi = hashFunction(key);
// int di = searchInLL(key, bi);
// if (di != -1) {
// Node node = buckets[bi].get(di);
// return node.value;
// } else {
// return null;
// }
// }

// private ArrayList<K> keySet() {
// ArrayList<K> keys = new ArrayList<>();

// for (int i = 0; i < buckets.length; i++) {
// LinkedList<Node> ll = buckets[i];
// for (Node node : ll) {
// keys.add(node.key);
// }
// }
// return keys;
// }

// private boolean isEmpty() {
// return n == 0;
// }
// }

// public static void main(String[] args) {
// HashMap<String, Integer> map = new HashMap<>();

// // put
// map.put("India", 100);
// map.put("China", 150);
// map.put("US", 50);
// map.put("Nepal", 5);
// map.put("Srilanka", 3);
// map.put("Pakistan", 20); // triggers rehash once lambda > 2.0

// // get
// System.out.println("Population of India: " + map.get("India"));
// System.out.println("Population of Germany: " + map.get("Germany")); // null

// // containsKey
// System.out.println("Contains China? " + map.containsKey("China"));
// System.out.println("Contains Japan? " + map.containsKey("Japan"));

// // update existing key
// map.put("India", 110);
// System.out.println("Updated population of India: " + map.get("India"));

// // isEmpty
// System.out.println("Is map empty? " + map.isEmpty());

// // keySet
// System.out.println("Keys: " + map.keySet());

// // remove
// System.out.println("Removed Nepal: " + map.remove("Nepal"));
// System.out.println("Contains Nepal after removal? " +
// map.containsKey("Nepal"));
// }
// }
