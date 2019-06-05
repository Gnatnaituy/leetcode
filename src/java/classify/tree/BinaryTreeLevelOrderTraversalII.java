package java.classify.tree;

import java.others.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    /**
     * 1ms 88.72%
     * 37.3MB 61.55%
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        List<Integer> level;
        int size;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            level = new ArrayList<>();
            size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }

            res.addFirst(level);
        }

        return res;
    }

    /**
     * Recursive
     * 1ms 88.72%
     * 37.4% 32.11%
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        levelHelper(res, root, 0);

        return res;
    }

    private void levelHelper(LinkedList<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;

        if (height >= res.size()) {
            res.addFirst(new ArrayList<>());
        }

        res.get(res.size() - height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }
}
