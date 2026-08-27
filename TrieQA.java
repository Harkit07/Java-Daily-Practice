public class TrieQA {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    // Insert in Trie
    public static void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Search in Trie
    public static boolean search(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    // Word Break Problem
    public static boolean wordBreak(String str) {
        if (str.length() == 0) {
            return true;
        }
        for (int i = 1; i <= str.length(); i++) {
            if (search(str.substring(0, i)) && wordBreak(str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    // Prefix Problem
    public static void insertUtil(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void prefixProblem(Node root, String ans) {
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                prefixProblem(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    // Starts With Problem

    // Count Unique String

    // Longest Word With All Prefix

    public static void main(String[] args) {
        // Insert in Trie
        // String wordArr1[] = { "the", "a", "there", "theirs", "any", "thee" };
        // for (int i = 0; i < wordArr1.length; i++) {
        // insert(wordArr1[i]);
        // }

        // Search in Trie
        // String key1 = "thee";
        // String key2 = "thor";
        // System.out.println(search(key1));
        // System.out.println(search(key2));

        // Word Break Problem
        // String wordArr2[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // String key = "ilikesamsung";
        // for (int i = 0; i < wordArr2.length; i++) {
        // insert(wordArr2[i]);
        // }
        // System.out.println(wordBreak(key));

        // Prefix Problem
        String arr[] = { "zebra", "dog", "duck", "dove" };
        // ans[]={"z", "dog", "du", "du"};
        root.freq = -1;
        for (int i = 0; i < arr.length; i++) {
            insertUtil(arr[i]);
        }
        prefixProblem(root, "");

        // Starts With Problem
        String wordArr3[] = { "apple", "app", "mango", "man", "woman" };
        String prefix1 = "app";// true
        String prefix2 = "moon";// false

        // Count Unique String
        String str = "ababa";// ans=10

        // Longest Word With All Prefix
        String wordArr4[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };// ans="apple";
    }

}
