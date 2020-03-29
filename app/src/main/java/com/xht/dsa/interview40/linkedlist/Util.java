package com.xht.dsa.interview40.linkedlist;

import com.xht.dsa.interview40.bean.ListNode;

/**
 * Created by xht on 2020/3/29
 */
public class Util {

    public static void traversal(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "   ");
            node = node.next;
        }
        System.out.println();
    }

}
