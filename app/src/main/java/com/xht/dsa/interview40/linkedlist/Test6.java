package com.xht.dsa.interview40.linkedlist;

import com.xht.dsa.interview40.bean.ListNode;

/**
 * Created by xht on 2020/3/30
 */
public class Test6 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Util.traversal(node1);
        ListNode node = deleteDup(node1);
        Util.traversal(node);
    }


    /*
        头结点可能与后面的结点重复，也就是说头结点也可能被删除，所以在链表头添加一个结点。

        接下来我们从头遍历整个链表。如果当前结点的值与下一个结点的值相同，那么它们就是重复的结点，都可以被删除。
        为了保证删除之后的链表仍然是相连的而没有中间断开，我们要把当前的前一个结点和后面值比当前结点的值要大的结点相连。
        我们要确保prev要始终与下一个没有重复的结点连接在一起。
     */
    private static ListNode deleteDup(ListNode head) {
        ListNode first = new ListNode(-1);
        first.next = head;

        ListNode cur = head;

        ListNode last = first;

        while (cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                int val = cur.val;
                while (cur!= null && cur.val == val) {
                    cur = cur.next;
                }
                last.next = cur;
            } else {
                last = cur;
                cur = cur.next;
            }
        }

        return first.next;
    }

    /*
        由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
        如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
     */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if(current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

}
