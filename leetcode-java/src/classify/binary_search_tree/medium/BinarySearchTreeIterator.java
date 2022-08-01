package classify.binary_search_tree.medium;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

public class BinarySearchTreeIterator {

    private List<Integer> nums = new ArrayList<>();
    private int curIndex = 0;
    private int size = 0;

    /**
     * 13ms     93.26%
     * 45MB     78.27%
     */
    public BinarySearchTreeIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        nums.add(node.val);
        size++;
        inorder(node.right);
    }
    
    public int next() {
        return curIndex < size ? nums.get(curIndex++) : -1;
    }
    
    public boolean hasNext() {
        return curIndex < size - 1;
    }
}
