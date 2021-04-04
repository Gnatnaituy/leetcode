package classify.recursion;

import tools.TreeNode;

/**
 * @author yutiantang
 * @create 2021/4/4 23:27
 */
public class IncreasingOrderSearchTree {

    /**
     * 0ms      100.00%
     * 36.2MB   8.91%
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode fakeHead = new TreeNode(0);
        if (root.left != null) {
            fakeHead.right = increasingBST(root.left);
        }
        TreeNode cur = fakeHead;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = new TreeNode(root.val);
        cur.right.right = increasingBST(root.right);

        return fakeHead.right;
    }
}
