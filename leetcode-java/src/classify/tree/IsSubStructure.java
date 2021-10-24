package classify.tree;

import tools.TreeNode;

/**
 * @author yutiantang
 * @create 2021/10/24 14:51
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class IsSubStructure {

    /**
     * 0ms      100.00%
     * 40.1MB   65.59%
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (isSubTree(A, B)) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
