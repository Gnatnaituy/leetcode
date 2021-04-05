package classify.recursion;

import tools.TreeNode;

/**
 * @author yutiantang
 * @create 2021/4/5 11:31
 */
public class RangeSumOfBST {

    private int res = 0;

    /**
     * 1ms      52.13%
     * 46.2MB   87.95%
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.left != null) {
            rangeSumBST(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        rangeSumBST(root.right, low, high);

        return res;
    }
}
