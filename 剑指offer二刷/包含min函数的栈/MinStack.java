package 剑指offer二刷.包含min函数的栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wu
 * @date 2023年07月06日 13:08
 * @email dengwu.wu@foxmail.com
 */
public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> q = new ArrayDeque<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if (q.isEmpty() || x <= q.peekLast()) {
            q.addLast(x);
        }
    }

    public void pop() {
        int n = stack.pop();
        if (!q.isEmpty() && n == q.peekLast()) {
            q.pollLast();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return q.peekLast();
    }
}