package others.discover.algorithm.elementary.designproblem;


import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    private Stack<Integer> stack;

    /**
     * 119ms 26.39%
     * 47.3m 10.08%
     * 思路: 每次入栈两个元素, 一个元素本身, 一个当前栈的最小值
     * 用空间换取时间
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }
}

//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j + " x " + i + " = " + i * j + "    ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i <= 10; i++) {x`
//            int a = i > 5 ? i - 5 : 5 - i;
//            for (int j = 0; j <= 10; j++)
//                System.out.print(j - a == 0 || j + a == 10 ? "*" : " ");
//            System.out.println();
//        }
