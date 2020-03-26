package com.xht.dsa.interview40.linkedlist;

import com.xht.dsa.interview40.bean.ListNode;

public class Test3 {

    /*
        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

        示例:
        给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        traversal(listNode1);

        //traversal(swapPairs1(listNode1));
        traversal(swapPairs2(listNode1));


    }


    /*
        递归

        递归写法要观察本级递归的解决过程，形成抽象模型，因为递归本质就是不断重复相同的事情。
        而不是去思考完整的调用栈，一级又一级，无从下手。

        其中我们应该关心的主要有三点：
            1）返回值
            2）调用单元做了什么
            3）终止条件

        在本题中：
            返回值：交换完成的子链表
            调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
            终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     */
    public static ListNode swapPairs1(ListNode head) {
        // 1. 终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了
        if (head == null || head.next == null) {
            return head;
        }

        // 2. 调用单元
        // 需要交换的两个节点是 head 和 head.next
        ListNode next = head.next;

        // head 连接后面交换完成的子链表
        head.next = swapPairs1(next.next);
        // head.next 连接head
        next.next = head;

        // 3. 返回值：返回交换完成的子链表
        // next 变成了头结点
        return next;
    }


    /*
        1--->2--->3--->4--->5

        设置一个prev节点0     0--->1--->2--->3--->4--->5

        记录当前temp节点 初始为0节点

        要交换的节点  start   end

        0--->2--->1--->3--->4--->5

        将当前节点temp的next 设为end，start节点的next


     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode prev = new ListNode(0);

        prev.next = head;
        ListNode temp = prev;

        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }

        return prev.next;
    }


    private static void traversal(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "   ");
            node = node.next;
        }
        System.out.println();
    }


}
