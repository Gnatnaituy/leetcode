package easy.gtwenty;

import org.w3c.dom.Node;
import tools.NNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559 Max Depth of A-ary Tree
 *
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along
 * the longest path from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 *
 *          3
 *       /  |  \
 *      4   5   6
 *    /  \
 *   6    7
 *
 * We should return its max depth, which is 3.
 *
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */

public class MaxDepthOfNaryTree {
    private static int maxDepth(NNode root) {

        // DFS recursion
//        if (root == null) return 0;
//        int depth = 0;
//        for (int i = 0; i < root.children.size(); i++) {
//            depth = Math.max(depth, maxDepth(root.children.get(i)));
//        }
//        return depth + 1;


        // Hierarchical traversal
        if (root == null) return 0;
        if (root.children.size() == 1) return 1;

        int depth = 0;
        Queue<NNode> queue = new LinkedList<NNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            depth++;
            while (count > 0) {
                NNode nNode = queue.poll();
                if (nNode.children.size() == 0)
                    queue.addAll(nNode.children);
                count--;
            }
        }

        return depth;
    }
}
