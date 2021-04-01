package classify.recursion;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yutiantang
 * @create 2021/4/1 21:40
 */
public class MinimunDistanceBetweenBSTNodes {

    /**
     * 中序遍历
     * 1ms      27.48%
     * 35.9MB   71.66%
     * @param root
     * @return
     */
    int min = Integer.MAX_VALUE;
    List<Integer> values = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        midTraversal(root);
        int back = 0, front = 1;
        while (front < values.size()) {
            min = Math.min(min, values.get(front) - values.get(back));
            front++;
            back++;
        }

        return min;
    }

    private void midTraversal(TreeNode node) {
        if (node.left != null) {
            midTraversal(node.left);
        }
        values.add(node.val);
        if (node.right != null) {
            midTraversal(node.right);
        }
    }



    /**
     * 官方题解
     * @param root
     * @return
     */
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
