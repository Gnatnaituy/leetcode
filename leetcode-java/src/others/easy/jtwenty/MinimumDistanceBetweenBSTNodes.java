package others.easy.jtwenty;

import tools.TreeNode;

/**
 * 783 Minimum Distance Between BST Nodes
 */

public class MinimumDistanceBetweenBSTNodes {
    int res = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return res;


        // 2019-01-01 18:38 version 1 Misunderstand the title
        // int res = Integer.MAX_VALUE;
        // List<Integer> nodes = new ArrayList<>();
        // Queue<TreeNode> queueandbfs = new ArrayDeque<>();
        // queueandbfs.add(root);
        // while (!queueandbfs.isEmpty()) {
        //     int size = queueandbfs.size();
        //     while (size > 0) {
        //         TreeNode node = queueandbfs.poll();
        //         nodes.add(node.val);
        //         if (node.left != null) queueandbfs.add(node.left);
        //         if (node.right != null) queueandbfs.add(node.right);
        //         size--;
        //     }
        // }
        // Collections.sort(nodes);
        // for (int i = 0; i < nodes.size() - 1; i++) {
        //     int sub = (int) nodes.get(i + 1) - nodes.get(i);
        //     if (sub < res) res = sub;
        // }
        // return res;
    }

    void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (pre == Integer.MAX_VALUE) {
                pre = root.val;
            } else {
                res = Math.min(res, root.val - pre);
                pre = root.val;
            }
            inOrder(root.right);
        }
    }
}
