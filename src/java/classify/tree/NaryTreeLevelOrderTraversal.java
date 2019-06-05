package java.classify.tree;

import java.others.tools.NNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

    /**
     * Iterative
     * 3ms 86.30%
     * 47.1MB 77.54%
     */
    public List<List<Integer>> levelOrder(NNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<NNode> queue = new LinkedList<>();
        List<Integer> level;
        int size;

        queue.add(root);
        while (!queue.isEmpty()) {
            level = new LinkedList<>();
            size = queue.size();

            while (size > 0) {
                NNode node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
                size--;
            }

            res.add(level);
        }

        return res;
    }

    /**
     * Recursive
     * 2ms 94.37%
     * 49.2MB 28.63%
     */
    public List<List<Integer>> levelOrder2(NNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);

        return res;
    }

    private void levelHelper(List<List<Integer>> res, NNode root, int height) {
        if (root == null) return;

        if (height >= res.size()) res.add(new ArrayList<>());

        res.get(height).add(root.val);
        for (NNode node : root.children) {
            levelHelper(res, node, height + 1);
        }
    }
}
