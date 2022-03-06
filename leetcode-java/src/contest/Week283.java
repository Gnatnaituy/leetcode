package contest;

import java.util.*;

public class Week283 {

    public Week283() {
    }

    public static List<String> cellsInRange(String s) {
        char startCol = s.charAt(0), endCol = s.charAt(3);
        int startRow = s.charAt(1), endRow = s.charAt(4);
        List<String> res = new ArrayList<>();

        while (startCol <= endCol) {
            while (startRow <= endRow) {
                res.add("" + startCol + (startRow - 48));
                startRow++;
            }
            startRow = s.charAt(1);
            startCol++;
        }

        return res;
    }

    /**
     * 超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum(int[] nums, int k) {
        long res = 0, cur = 1;
        Arrays.sort(nums);

        for (int i = 0; k > 0; ) {
            if (i == nums.length || cur != nums[i]) {
                res += cur;
                k--;
                cur++;
            } else {
                i++;
                cur = i == nums.length || cur != nums[i] ? cur + 1 : cur;
            }
        }

        return res;
    }

    /**
     * 可能漏掉一些需要替换的值
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum2(int[] nums, int k) {
        int res = (k + 1) * (k / 2);
        res += (k % 2) == 1 ? (k + 1) / 2 : 0;
        HashMap<Integer, Integer> uniques = new HashMap<>();

        for (int num : nums) {
            if (!uniques.containsKey(num)) {
                if (num <= k) {
                    res += k - num + 1;
                    k++;
                }
                uniques.put(num, 1);
            } else {
                if (num <= k) {
                    res += k - num + uniques.get(num) + 1;
                    uniques.put(num, uniques.get(num) + 1);
                }
            }
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>(descriptions.length);
        HashSet<TreeNode> heads = new HashSet<>();
        boolean isLeft;

        for (int[] tree : descriptions) {
            isLeft = tree[2] == 1;
            TreeNode node = map.get(tree[0]);
            TreeNode child = map.get(tree[1]);
            if (child == null) {
                child = new TreeNode(tree[1]);
                map.put(tree[1], child);
            } else {
                heads.remove(child);
            }
            if (node != null) {
                if (isLeft) {
                    node.left = child;
                } else {
                    node.right = child;
                }
            } else {
                node = new TreeNode(tree[0], isLeft ? child : null, isLeft ? null : child);
                map.put(tree[0], node);
                heads.add(node);
            }
        }

        return heads.iterator().next();
    }

    public static void main(String[] args) {
        long res = minimalKSum2(new int[]{1,4,25,10,25}, 2);
        System.out.println(res);
    }
}
