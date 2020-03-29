package com.xht.dsa.interview40.linkedlist;

import com.xht.dsa.interview40.bean.ListNode;

/**
 * Created by xht on 2020/3/29
 */
public class Test5 {

    /*
        请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

        输入: head = [4,5,1,9], node = 5
        输出: [4,1,9]
        解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

        说明:
        链表至少包含两个节点。
        链表中所有节点的值都是唯一的。
        给定的节点为非末尾节点并且一定是链表中的一个有效节点。
        不要从你的函数中返回任何结果。
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
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Util.traversal(node1);
//        deleteNode(node2);

        ListNode delete = delete(node1, 1);
        System.out.println("after delete " + delete.val);
        Util.traversal(delete);
    }

    /*
        将要被删除的下一个交换到要删除的节点位置

        时间和空间复杂度都是：O(1)O(1)。

        注意赋值的先后，

        或者可以先建一个变量保存next节点
     */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*
        特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
        初始化： pre = head , cur = head.next 。
        定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出。
        保存当前节点索引，即 pre = cur 。
        遍历下一节点，即 cur = cur.next 。
        删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next ；当 cur 指向 nullnull 时，代表链表中不包含目标节点。
        返回值： 返回链表头部节点 head 即可。
     */
    private static ListNode delete(ListNode head, int val) {
        if(val == head.val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        if(cur != null) {
            pre.next = cur.next;
        }

        return head;
    }

}
