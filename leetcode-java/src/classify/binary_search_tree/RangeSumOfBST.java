package classify.binary_search_tree;

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

    /**
     * 优化不必要的递归
     * 0ms      100.00%
     * 48.6MB   81.37%
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.val >= low) {
            rangeSumBST(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (root.right != null && root.val <= high) {
            rangeSumBST(root.right, low, high);
        }

        return res;
    }
}
