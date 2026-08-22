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

    // Sorted Array to balanced BST
    public static Node sortedArrToBST(int arr[], int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = st + (end - st) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortedArrToBST(arr, st, mid - 1);
        root.right = sortedArrToBST(arr, mid + 1, end);
        return root;
    }

    // Convert BST to Balance BST
    private static void getInOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    }

    private static Node createBST(ArrayList<Integer> list, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = st + (end - st) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, st, mid - 1);
        root.right = createBST(list, mid + 1, end);
        return root;
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        getInOrder(root, list);

        root = createBST(list, 0, list.size() - 1);
        return root;
    }

    // Size of Largest BST in BTs
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBSt = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBSt = Math.max(maxBSt, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
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

        System.out.println("\n===== Sorted Array to Balanced BST =====");
        int sortedArr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node balancedFromArr = sortedArrToBST(sortedArr, 0, sortedArr.length - 1);
        System.out.print("Inorder: ");
        inorder(balancedFromArr);
        System.out.println();

        System.out.println("\n===== Convert BST to Balanced BST =====");
        Node skewed = null;
        int[] skewedInsertOrder = { 1, 2, 3, 4, 5 };
        for (int v : skewedInsertOrder) {
            skewed = insert(skewed, v);
        }
        System.out.print("Before - Inorder: ");
        inorder(skewed);
        System.out.println();

        Node balanced = balanceBST(skewed);
        System.out.print("After  - Inorder: ");
        inorder(balanced);
        System.out.println();

        System.out.println("\n===== Size of Largest BST in Binary Tree =====");
        Node mixedTree = new Node(50);
        mixedTree.left = new Node(30);
        mixedTree.left.left = new Node(5);
        mixedTree.left.right = new Node(20);
        mixedTree.right = new Node(60);
        mixedTree.right.left = new Node(45);
        mixedTree.right.right = new Node(70);
        mixedTree.left.right.left = new Node(100); // violates BST for the whole left subtree

        maxBSt = 0; // reset static counter before use
        largestBST(mixedTree);
        System.out.println("Size of largest BST subtree: " + maxBSt);
    }
}
