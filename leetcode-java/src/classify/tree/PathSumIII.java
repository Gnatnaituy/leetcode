package classify.tree;

import tools.TreeNode;

public class PathSumIII {

    /**
     * 11ms 63.97%
     * 40.8MB 46.00%
     */
    public int pathSum(TreeNode root, int targetSum) {
        return (int) pathSumFrom(root, targetSum);
    }

    private long pathSumFrom(TreeNode node, long targetSum) {
        if (node == null) return 0L;

        long cur = node.val == targetSum ? 1L : 0L;
        long left = pathSumFrom(node.left, targetSum - node.val);
        long right = pathSumFrom(node.right, targetSum - node.val);

        return cur + left + right;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1000000000);
        node.left = new TreeNode(1000000000);
        node.left.left = new TreeNode(294967296);
        node.left.left.left = new TreeNode(1000000000);
        node.left.left.left.left = new TreeNode(1000000000);
        node.left.left.left.left.left = new TreeNode(1000000000);

        System.out.println(new PathSumIII().pathSum(node, 0));
    }
}
