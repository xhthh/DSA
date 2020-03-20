package com.xht.dsa.ds;

/**
 * Created by xht on 2020/3/16
 */
public class DoubleLink<T> {

    //表头
    private DNode<T> mHead;
    //节点个数
    private int mCount;

    private class DNode<T> {
        public DNode prev;
        public DNode next;
        public T value;

        public DNode(T value, DNode prev, DNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoubleLink() {
        //创建“表头”，注意：表头没有存储数据
        mHead = new DNode<>(null, null, null);
        mHead.prev = mHead.next = mHead;
        mCount = 0;
    }

    //返回节点数目
    public int size() {
        return mCount;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return mCount == 0;
    }

    private DNode<T> getNode(int index) {
        if (index < 0 || index >= mCount) {
            throw new IndexOutOfBoundsException();
        }

        //正向查找
        if (index <= mCount / 2) {
            DNode<T> node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        //反向查找
        DNode<T> rnode = mHead.prev;
        int rindex = mCount - index - 1;
        for (int j = 0; j < rindex; j++) {
            rnode = rnode.prev;
        }
        return rnode;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public T getLast() {
        return getNode(mCount - 1).value;
    }

    public void insert(int index, T t) {
        if (index == 0) {
            DNode<T> node = new DNode<>(t, mHead, mHead.next);
            mHead.next.prev = node;
            mHead.next = node;
            mCount++;
            return;
        }

        DNode<T> inode = getNode(index);
        DNode<T> tnode = new DNode<T>(t, inode.prev, inode);
        inode.prev.next = tnode;
        inode.prev = tnode;
        mCount++;
    }

    public void insertFirst(T t) {
        insert(0, t);
    }

    public void appendLast(T t) {
        DNode<T> node = new DNode<>(t, mHead.prev, mHead);
        mHead.prev.next = node;
        mHead.prev = node;
        mCount++;
    }

    public void del(int index) {
        DNode<T> inode = getNode(index);
        inode.prev.next = inode.next;
        inode.next.prev = inode.prev;
        inode = null;
        mCount--;
    }

    public void deleteFirst() {
        del(0);
    }

    public void deleteLast() {
        del(mCount - 1);
    }


}
