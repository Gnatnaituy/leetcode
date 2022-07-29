package classify.binary_search_tree.easy;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

public class FindModeInBinarySearchTree {

    List<Integer> res = new ArrayList<>();
    int num, count, max;

    /**
     * 0ms      100.00%
     * 41.6MB   79.32%
     */
    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        int[] mode = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            mode[i] = res.get(i);
        }

        return mode;
    }

    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        updateMax(node.val);
        inorderTraversal(node.right);
    }

    public void updateMax(int x) {
        if (x == num) {
            ++count;
        } else {
            count = 1;
            num = x;
        }

        if (count == max) {
            res.add(num);
        }
        
        if (count > max) {
            max = count;
            res.clear();
            res.add(num);
        }
    }
}
