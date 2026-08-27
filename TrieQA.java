public class TrieQA {
    // Insert in Trie

    // Search in Trie

    // Word Break Problem

    // Prefix Problem

    // Starts With Problem

    // Count Unique String

    // Longest Word With All Prefix

    public static void main(String[] args) {
        // Insert in Trie
        String wordArr1[] = { "the", "a", "there", "theirs", "any", "thee" };

        // Search in Trie
        String key1 = "thee";
        String key2 = "thor";

        // Word Break Problem
        String wordArr2[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String key = "ilikesamsung";

        // Prefix Problem
        String arr[] = { "zebra", "dog", "duck", "dove" };
        // ans[]={"z", "dog", "du", "du"};

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
