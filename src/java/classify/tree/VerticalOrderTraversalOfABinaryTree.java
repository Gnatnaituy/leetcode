package java.classify.tree;

import java.others.tools.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

    /**
     * 3ms 93.33%
     * 37.5MB 17.39%
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        
        return list;
    }

    private void dfs(TreeNode root, int index, int depth, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(index)) {
            map.put(index, new TreeMap<>());
        }

        if (!map.get(index).containsKey(depth)) {
            map.get(index).put(depth, new PriorityQueue<>());
        }

        map.get(index).get(depth).offer(root.val);
        dfs(root.left, index - 1, depth + 1, map);
        dfs(root.right, index + 1, depth + 1, map);
    }
}
