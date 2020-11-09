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

    private static void printAllNodes(TreeNode<String> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        printAllNodes(node.left);
        printAllNodes(node.right);
    }
}
