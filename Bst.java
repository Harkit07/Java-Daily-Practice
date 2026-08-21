import java.util.ArrayList;

public class Bst {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Build a BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Search in BST
    public static boolean searchBST(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return searchBST(root.left, key);
        } else {
            return searchBST(root.right, key);
        }
    }

    // Delete a Node
    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node IS = findInOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    // Print in Range k1-k2
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    // Root to Leaf Paths
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void leafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        leafPath(root.left, path);
        leafPath(root.right, path);
        path.remove(path.size() - 1);
    }

    // Validate BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Mirror BST
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    // InOrder
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.println("===== 1. Build BST =====");
        System.out.print("Inorder (should be sorted): ");
        inorder(root);
        System.out.println();

        System.out.println("\n===== 2. Search in BST =====");
        System.out.println("Search 4: " + searchBST(root, 4));
        System.out.println("Search 6: " + searchBST(root, 6));

        System.out.println("\n===== 3. Validate BST =====");
        System.out.println("isValidBST: " + isValidBST(root, null, null));

        System.out.println("\n===== 4. Print In Range [2, 5] =====");
        printInRange(root, 2, 5);
        System.out.println();

        System.out.println("\n===== 5. Root to Leaf Paths =====");
        leafPath(root, new ArrayList<>());

        System.out.println("\n===== 6. Delete Node 3 (two children) =====");
        root = delete(root, 3);
        inorder(root);
        System.out.println();

        System.out.println("\n===== 7. Delete Node 7 (leaf) =====");
        root = delete(root, 7);
        inorder(root);
        System.out.println();

        System.out.println("\n===== 8. Mirror BST =====");
        root = mirrorBST(root); // using the FIXED version (swaps left/right)
        inorder(root);
    }
}
