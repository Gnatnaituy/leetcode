package classify.dp;

import java.util.HashMap;

import tools.TreeNode;

public class HouseRobberIII {

    /**
     * 超出时间限制
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }
    
    /**
     * 超出时间限制
     */
    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> mem = new HashMap<>();
        return helper2(root, mem);
    }

    public int helper2(TreeNode node, HashMap<TreeNode, Integer> mem) {
        if (node == null) return 0;
        if (mem.containsKey(node)) return mem.get(node);

        int money = node.val;
        if (node.left != null) {
            money += rob(node.left.left) + rob(node.left.right);
        }
        if (node.right != null) {
            money += rob(node.right.left) + rob(node.right.right);
        }

        int res = Math.max(money, rob(node.left) + rob(node.right));
        mem.put(node, res);
        
        return res;
    }

    /**
     * 0ms      100.00%
     * 40.8MB   91.34%
     */
    public int rob3(TreeNode root) {
        int[] result = helper3(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] helper3(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];
    
        int[] left = helper3(root.left);
        int[] right = helper3(root.right);
    
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
    
        return result;
    }
}
