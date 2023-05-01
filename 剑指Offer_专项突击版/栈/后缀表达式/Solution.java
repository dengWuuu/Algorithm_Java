package 剑指Offer_专项突击版.栈.后缀表达式;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Wu
 * @date 2022年10月01日 13:51
 */
public class Solution {
    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!Objects.equals(token, "+") && !Objects.equals(token, "-") && !Objects.equals(token, "*") && !Objects.equals(token, "/")) {
                stack.push(token);
            } else {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(right + left + "");
                        break;
                    case "-":
                        stack.push(left - right + "");
                        break;
                    case "*":
                        stack.push(left * right + "");
                        break;
                    case "/":
                        stack.push(left / right + "");
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
