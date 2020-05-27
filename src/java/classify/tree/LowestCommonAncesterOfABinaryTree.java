package java.classify.tree;

import java.tools.TreeNode;


public class LowestCommonAncesterOfABinaryTree {

    /**
     * 974ms 5.00%
     * 34.2MB 48.57%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;

//        boolean pInLeft = inTree(root.left, p.val);
//        boolean qInLeft = inTree(root.left, q.val);
//        if (inTree(root.left, p.val) && inTree(root.left, q.val))
//            return lowestCommonAncestor(root.left, p, q);
//        if (inTree(root.right, p.val) && inTree(root.right, q.val))
//            return lowestCommonAncestor(root.right, p, q);

        // 改进后: 542ms 5.00%
        boolean pInLeft = inTree(root.left, p.val);
        boolean qInLeft = inTree(root.left, q.val);

        if (pInLeft && qInLeft) return lowestCommonAncestor(root.left, p, q);
        if (!pInLeft && !qInLeft) return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    private boolean inTree(TreeNode root, int value) {
        if (root == null) return false;
        if (root.val == value) return true;

        return inTree(root.left, value) || inTree(root.right, value);
    }

    /**
     * 74ms 6.84%
     * 175.5MB 5.11%
     * 根据两个节点在二叉树中路径相同段来判断
     */
    private String pPath = "";
    private String qPath = "";
    private int pVal;
    private int qVal;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        pVal = p.val;
        qVal = q.val;
        helper(root, new StringBuilder());

        if ("".equals(pPath) || "".equals(qPath)) {
            return root;
        } else {
            TreeNode res = root;
            int i = 0;
            while (true) {
                if (i == pPath.length() || i == qPath.length() || pPath.charAt(i) != qPath.charAt(i))
                    return res;
                res = pPath.charAt(i) == '-' ? res.left : res.right;
                i++;
            }
        }
    }

    private void helper(TreeNode root, StringBuilder path) {
        if (root == null) return;
        if (root.val == pVal) pPath = path.toString();
        if (root.val == qVal) qPath = path.toString();

        helper(root.left, new StringBuilder(path).append("-"));
        helper(root.right, new StringBuilder(path).append("+"));
    }

    /**
     * 5ms
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
