package huahua.tree;

import others.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {
    private static final String SEP = ",";
    private static final String NULL = "null";

    /**
     * 9ms 49.24%
     * 41MB 12.31%
     */
    public String serialize(TreeNode root) {
        if (root == null) return NULL;

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();

        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // pre-order traversal
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }

        return getNode(q);
    }

    // some notes:
    //   5
    //  3 6
    // 2   7
    private TreeNode getNode(Queue<Integer> q) { //q: 5,3,2,6,7
        if (q.isEmpty()) return null;

        TreeNode root = new TreeNode(q.poll());//root (5)
        Queue<Integer> smallerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            smallerQueue.offer(q.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = getNode(smallerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = getNode(q);

        return root;
    }
}
