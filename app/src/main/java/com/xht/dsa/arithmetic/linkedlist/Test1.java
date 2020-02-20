package com.xht.dsa.arithmetic.linkedlist;

/**
 * Created by xht on 2020/2/20
 * 如何判断链表有环
 */
public class Test1 {

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;

        boolean isCycle = isCycle(node1);
        System.out.println("是否有环：" + isCycle);

        int cycleLength = getCycleLength(node1);
        System.out.println("环的长度：" + cycleLength);

        Node pointCut = getPointCut(node1);
        System.out.println("入环节点：" + pointCut.data);
    }

    /**
     * 1、判断链表是否有环
     * 使用两个指针，以不同速度移动，是否有相等的时候，有即有环，无则无环
     *
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

    /**
     * 2、如果有环，求环的长度
     * <p>
     * 假设从链表头节点到入环点的距离为 D
     * 从入环点到两个指针首次相遇点的距离是 S1
     * 从首次相遇点回到入环点的距离是 S2

     * 指针 p1 一次只走1步，所走距离是 D + S1
     * 指针 p2 一次只走2步，多走了 1 圈，所走的距离是 D + S1 + S2 + S1
     *
     * 即第一次相遇后，第二次相遇时，p1走的步数，即环长
     *
     * 由于 p2 的速度是 p1 的2倍，所以所走的距离也是 p1 的2倍，即：
     * 2(D+S1) = D + S1 + S2 + S1，即 D = S2
     *
     * 也就是说从链表头节点到入环点的距离，等于首次相遇点回到入环点的距离
     *
     * 这样一来，只要把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，
     * 两个指针都是每次向前走1步，那么，它们最终相遇的节点，就是入环节点。
     *
     * @return
     */
    public static int getCycleLength(Node head) {
        Node p1 = head;
        Node p2 = head;

        int length = 0;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                System.out.println("第一次相遇点：" + p1.data);
                while (true) {
                    p1 = p1.next;
                    p2 = p2.next.next;
                    length++;
                    if (p1 == p2) {
                        System.out.println("第二次相遇点：" + p1.data);
                        return length;
                    }
                }
            }
        }

        return length;
    }

    /**
     * 由于 p2 的速度是 p1 的2倍，所以所走的距离也是 p1 的2倍，即：
     * 2(D+S1) = D + S1 + S2 + S1，即 D = S2
     *
     * 也就是说从链表头节点到入环点的距离，等于首次相遇点回到入环点的距离
     *
     * 这样一来，只要把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，
     * 两个指针都是每次向前走1步，那么，它们最终相遇的节点，就是入环节点。
     * @param head
     * @return
     */
    public static Node getPointCut(Node head) {
        Node p1 = head;
        Node p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if(p1 == p2) {
                p1 = head;

                while (true) {
                    p1 = p1.next;
                    p2 = p2.next;

                    if(p1 == p2) {
                        return p2;
                    }
                }
            }
        }

        return null;
    }


    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
