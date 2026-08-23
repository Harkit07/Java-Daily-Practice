import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // Create Binary Tree
    static class BinaryTrees {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // Pre-Order Traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-Order Traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Post-Order Traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Level-Order Traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);

                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // Count Height of Tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    // Count Node of Tree
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1;
    }

    // Count Sum of Tree
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
    }

    // Diameter of a Tree - Approac 1
    // public static int daimeter(Node root) {
    // if (root == null) {
    // return 0;
    // }
    // int leftDaim = daimeter(root.left);
    // int leftHeight = height(root.left);
    // int rightDaim = daimeter(root.right);
    // int rightHeight = height(root.right);

    // int selfDaim = leftHeight + rightHeight + 1;
    // return Math.max(selfDaim, Math.max(rightDaim, leftDaim));
    // }

    // Diameter of a Tree - Approac 2
    // static class Info {
    // int ht;
    // int daim;

    // public Info(int ht, int daim) {
    // this.ht = ht;
    // this.daim = daim;
    // }

    // }

    // public static Info daimeter(Node root) {
    // if (root == null) {
    // return new Info(0, 0);
    // }
    // Info leftInfo = daimeter(root.left);
    // Info rightInfo = daimeter(root.right);

    // int daim = Math.max(Math.max(leftInfo.daim, rightInfo.daim), leftInfo.ht +
    // rightInfo.ht + 1);
    // int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
    // return new Info(ht, daim);
    // }

    // Subtree of Another Tree
    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || root.data != subroot.data) {
            return false;
        }
        if (!isIdentical(root.left, subroot.left)) {
            return false;
        }
        if (!isIdentical(root.right, subroot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    // Top View of a Tree
    static class Info {
        int ht;
        Node node;

        public Info(int ht, Node node) {
            this.ht = ht;
            this.node = node;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            System.out.println();
            return;
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, root));
        q.add(null);
        int min = 0, max = 0;
        HashMap<Integer, Node> hm = new HashMap<>();
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!hm.containsKey(curr.ht)) {
                    hm.put(curr.ht, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info(curr.ht - 1, curr.node.left));
                    min = Math.min(min, curr.ht - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.ht + 1, curr.node.right));
                    max = Math.max(max, curr.ht + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(hm.get(i).data + " ");
        }
        System.out.println();
    }

    // Print Kth Level of Node in Tree
    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (k == level) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    // Lowest Common Ancestor - Approach 1
    public static boolean getPath(Node root, ArrayList<Node> path, int n) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, path, n);
        boolean foundRight = getPath(root.right, path, n);
        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, path1, n1);
        getPath(root, path2, n2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }

    // Lowest Common Ancestor - Approach 2
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }
        return root;
    }

    // Min Distance Between Nodes
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        return Math.max(leftDist, rightDist) + 1;
    }

    public static int minDiff(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        Node lca = lca2(root, n1, n2);
        int leftDist = lcaDist(lca, n1);
        int rightDist = lcaDist(lca, n2);

        return leftDist + rightDist;
    }

    // kth Ancestor of Nodes
    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);
        if (left == -1 && right == -1) {
            return -1;
        }
        int max = Math.max(left, right);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // Transform to Sum Tree
    public static int transformTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transformTree(root.left);
        int rightChild = transformTree(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = leftChild + newLeft + rightChild + newRight;
        return data;
    }

    // Transform to Sum Tree short
    public static int toSumTree(Node node) {
        if (node == null)
            return 0;
        int old = node.data;
        node.data = toSumTree(node.left) + toSumTree(node.right);
        return old + node.data; // return ORIGINAL + NEW combined
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTrees.buildTree(nodes);
        // System.out.println(root.data);
        // preOrder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();
        // postOrder(root);
        // System.out.println();
        // levelOrder(root);
        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        // System.out.println(daimeter(root));
        // System.out.println(daimeter(root).daim);
        // BinaryTrees.idx = -1;
        // int subNodes[] = { 2, 4, -1, -1, 5, -1, -1 };
        // Node subroot = BinaryTrees.buildTree(subNodes);
        // System.out.println(isSubtree(root, subroot));
        // topView(root);
        // kthLevel(root, 0, 2);
        // System.out.println(lca1(root, 4, 5).data);
        // System.out.println(lca2(root, 4, 5).data);
        // System.out.println(minDiff(root, 4, 6));
        // System.out.println(kthAncestor(root, 4, 2));
        // transformTree(root);
        toSumTree(root);
        preOrder(root);
    }
}
    