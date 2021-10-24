package classify.tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yutiantang
 * @create 2021/10/24 14:33
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class BinaryTreeLevelOrderPrintIII {

    /**
     * 1ms      97.85%
     * 383.MB   95.14%
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<Integer> level;
        int size;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean isOddLevel = false;
        while (!queue.isEmpty()) {
            level = new LinkedList<>();
            size = queue.size();
            isOddLevel = !isOddLevel;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (isOddLevel) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }

            res.add(level);
        }

        return res;
    }
}
