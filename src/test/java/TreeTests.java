import org.junit.Test;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class TreeTests {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("Katie");

        root.left = new TreeNode<>("Jerry");
        root.left.left = new TreeNode<>("Alex");
        root.left.right = new TreeNode<>("Joe");

        root.right = new TreeNode<>("Sam");
        root.right.left = new TreeNode<>("Ron");
        root.right.right = new TreeNode<>("Tim");

        printAllNodes(root);

    }

    @Test
    public void useTreeMap() {
        // key: name
        // value: password
        Map<String, String> tree = new TreeMap<>(); // a binary search tree, use key as node value
        tree.put("Jerry", "xyz");
        tree.put("Alex", "132");
        tree.put("Sam", "abc");
        tree.put("Ron", "def");
        tree.put("Tim", "opq");
        tree.put("Katie", "123");
        tree.put("Joe", "789");

        System.out.println(tree);

        System.out.println(tree.containsKey("Alex"));
        System.out.println(tree.containsKey("Andrew"));
    }

    private static void printAllNodes(TreeNode<String> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        printAllNodes(node.left);
        printAllNodes(node.right);
    }

    //
    //         3
    //        / \
    //       2   5
    //      / \
    //     8   9
    private void preorderTraverseIterative(TreeNode<Integer> treeNode) {

        Stack<TreeNode<Integer>> stack = new Stack<>();

        // push the first node
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();

            // visit middle
            System.out.println(node.val);

            // visit right
            if (node.right != null) {
                stack.push(node.right);
            }

            // visit left
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private void preorderTraverse(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }

        // visit middle
        System.out.println(treeNode.val);

        // visit left
        preorderTraverse(treeNode.left);

        // visit right
        preorderTraverse(treeNode.right);
    }

    @Test
    public void preorderTraverse() {
        TreeNode<Integer> tree = getLargeTree();
        preorderTraverse(tree);
        System.out.println();
        preorderTraverseIterative(getLargeTree());
    }

    private void inorderTraverse(TreeNode<Integer> treeNode) {

        if (treeNode == null) {
            return;
        }

        // visit left
        inorderTraverse(treeNode.left);

        // visit middle
        System.out.println(treeNode.val);

        // visit right
        inorderTraverse(treeNode.right);
    }

    @Test
    public void inorderTraverse() {
        inorderTraverse(getLargeTree());
    }

    @Test
    public void postorderTraverse() {
        postorderTraverse(getLargeTree());
    }

    private void postorderTraverse(TreeNode<Integer> treeNode) {

        if (treeNode == null) {
            return;
        }

        // visit left
        postorderTraverse(treeNode.left);

        // visit right
        postorderTraverse(treeNode.right);

        // visit middle
        System.out.println(treeNode.val);
    }

    //           8
    //         /   \
    //        3     10
    //       / \    / \
    //      1   6  2  14
    //         / \
    //        4  7
    private TreeNode<Integer> getLargeTree() {
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(6);
        root.left.right.left = new TreeNode<>(4);
        root.left.right.right = new TreeNode<>(7);

        root.right = new TreeNode<>(10);
        root.right.left = new TreeNode<>(2);
        root.right.right = new TreeNode<>(14);

        return root;
    }

    private int getHeight(TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int h1 = getHeight(treeNode.left);
        int h2 = getHeight(treeNode.right);

        return Math.max(h1, h2) + 1;
    }

    @Test
    public void testHeight() {
        int height = getHeight(getLargeTree());
        System.out.println(height);

    }
}
