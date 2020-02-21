package com.xht.dsa.arithmetic.stack;

import java.util.Stack;

/**
 * Created by xht on 2020/2/21
 * 实现一个栈，该栈带有出栈（pop）、入栈（push）、取最小元素（getMin）3个方法。
 * 要保证这3个方法的时间复杂度都是O(1)。
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack();

        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println("最小值：" + stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        //System.out.println("最小值：" + stack.getMin());
    }

    /**
     * 考虑出栈的情况，使用两个栈来完成
     * 一个辅助栈，用来存储曾经的最小值
     */
    public static class MyStack {
        private Stack<Integer> mainStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        private void push(int element) {
            mainStack.push(element);

            //如果辅助栈为空，或者新元素小于等于辅助栈栈顶元素，则将新元素压入辅助栈
            if (minStack.isEmpty() || element <= minStack.peek()) {
                minStack.push(element);
            }
        }

        private Integer pop() throws Exception {
            /*if (!mainStack.isEmpty()) {
                if (!minStack.isEmpty() && mainStack.peek() == minStack.peek()) {
                    minStack.pop();
                }

                return mainStack.pop();
            }

            return null;*/

            if(minStack.isEmpty()) {
                throw new Exception("Stack is empty");
            }

            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }

            return mainStack.pop();
        }

        private Integer getMin() throws Exception {
            /*if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return null;*/

            if (minStack.isEmpty()) {
                throw new Exception("Stack is empty");
            }

            return minStack.peek();
        }
    }

}
