package classify.tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /**
     * Iterative
     * 1ms 75.55%
     * 37.2MB 88.57%
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
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

            res.add(level);
        }

        return res;
    }

    /**
     * Recursive DFS
     * 0ms 100.00%
     * 37.3MB 78.63%
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);

        return res;
    }

    private void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;

        if (height >= res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    /**
     * 3ms      16.37%
     * 383.MB   92.49%
     * @param root
     * @return
     */
    public int[] levelOrder3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return new int[]{};

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return res.stream().mapToInt(o -> o).toArray();
    }

    /**
     * 1ms      98.66%
     * 38.6MB   47.25%
     * @param root
     * @return
     */
    public int[] levelOrder4(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        if (root == null) return new int[]{};

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            vals.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        int[] res = new int[vals.size()];
        int index = 0;
        for (int val : vals) res[index++] = val;

        return res;
    }
}
