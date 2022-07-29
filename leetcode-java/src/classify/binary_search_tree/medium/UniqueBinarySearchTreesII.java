package classify.binary_search_tree.medium;

import tools.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    /**
     * 1ms      97.30%
     * 42MB     49.70%
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return Collections.emptyList();

        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new LinkedList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTree(start, i - 1);
            List<TreeNode> subRightTree = generateTree(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }

        return res;
    }
}
