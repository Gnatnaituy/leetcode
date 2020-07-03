package others.easy.htwenty;

import tools.NNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 590 N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 */

public class NaryTreePostorderTraversal {

    private List<Integer> postorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<NNode> stack = new Stack<>();
        NNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            NNode curr = stack.peek();
            if((curr.children.size() == 0) || (pre != null && (curr.children.contains(pre)))) {
                res.add(curr.val);
                pre = curr;
                stack.pop();
            }else{
                for(int i = curr.children.size()-1; i >= 0; i--){
                    stack.push(curr.children.get(i));
                }
            }
        }
        return res;
    }
}
