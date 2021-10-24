package classify.tree;

import tools.TreeNode;

/**
 * @author yutiantang
 * @create 2021/10/24 15:12
 * 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class MirrorTree {

    /**
     * 0ms      100.00%
     * 35.2MB   99.99%
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);

        return node;
    }
}
