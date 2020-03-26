package com.xht.dsa.interview40.linkedlist;

import com.xht.dsa.interview40.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Test4 {

    /*
        判断链表是否有环

        给定一个链表，判断链表中是否有环。

        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        如果 pos 是 -1，则在该链表中没有环。
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node4;


        System.out.println("isCycle1=" + isCycle1(node1));
        System.out.println("isCycle2=" + isCycle2(node2));

        ListNode entry = entryNodeOfLoop(node1);
        System.out.println("entry=" + entry.val);
    }

    /*
        双指针
     */
    private static boolean isCycle1(ListNode node) {
        ListNode p1 = node;
        ListNode p2 = node;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

    /*
        使用 HashSet
     */
    private static boolean isCycle2(ListNode node) {
        Set<ListNode> set = new HashSet<>();

        while (node != null) {
            if (set.contains(node)) {
                return true;
            } else {
                set.add(node);
            }

            node = node.next;
        }

        return false;
    }

    /*
        p1走一步，p2走两步

        设起点到入环点，距离 D
        入环点到相遇点，距离 S1
        相遇点到入环点，距离 S2

        2*(D + S1) = D + S1 + n(S1 + S2);

        D = (n-1)(S1+S2) + S2

        即从链表头结点到入环点的距离，等于从首次相遇点绕环n-1圈再回到入环点的距离。
        这样一来，只要把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，
        两个指针都是每次向前走1步。那么，它们最终相遇的节点，就是入环节点。
     */
    public static ListNode entryNodeOfLoop(ListNode node) {

        ListNode p1 = node;
        ListNode p2 = node;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                p1 = node;

                while (true) {
                    p1 = p1.next;
                    p2 = p2.next;
                    if (p1 == p2) {
                        return p1;
                    }
                }

            }

        }

        return null;
    }



}
