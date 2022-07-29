package classify.binary_search_tree.easy;

import tools.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    
    /**
     * 6ms      33.80%
     * 41.9MB   90.47%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    /**
     * 5ms      99.99%
     * 42.9MB   5.09%
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }

        return ancestor;
    }
}
