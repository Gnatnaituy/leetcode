package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/26 10:38
 * @Description Week199
 */
public class Week199 {

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] res = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = chars[i];
        }

        return new String(res);
    }

    public int minFlips(String target) {
        int flippedCount = 0;
        char[] lights = target.toCharArray();

        for (char light : lights) {
            if ((light == '1' && flippedCount % 2 == 0) || (light == '0' && flippedCount % 2 == 1)) {
                flippedCount += 1;
            }
        }

        return flippedCount;
    }

    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;

        int res = 0;
        List<Integer> highs = dfs(root, 0);
        if (highs.size() < 2) return 0;

        for (int i = 0; i < highs.size() - 1; i++) {
            for (int j = i + 1; j < highs.size(); j++) {
                if (highs.get(i) + highs.get(j) <= distance) {
                    res++;
                }
            }
        }
        return res + countPairs(root.left, distance) + countPairs(root.right, distance);
    }

    public List<Integer> dfs(TreeNode node, int high) {
        if (node == null) return new ArrayList<>();
        if (node.left == null && node.right == null) {
            List<Integer> a = new ArrayList<>();
            a.add(high);
            return a;
        }
        List<Integer> res = dfs(node.left, high + 1);
        res.addAll(dfs(node.right, high + 1));
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right = new TreeNode(6);
        new Week199().countPairs(root, 3);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
