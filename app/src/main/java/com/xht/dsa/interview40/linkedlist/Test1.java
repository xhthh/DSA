package com.xht.dsa.interview40.linkedlist;

import com.xht.dsa.interview40.bean.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Test1 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        int[] result = traversal(node1);

        System.out.println(Arrays.toString(result));
    }

    /*
        因为是从尾到头，如果不能改变链表结构的话，可以用栈
     */
    private static int[] traversal(ListNode node) {
        Stack<ListNode> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        int size = stack.size();

        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = stack.pop().val;
        }

        return arr;
    }

}
