package com.xht.dsa.ds;

/**
 * Created by xht on 2020/3/16
 */
public class CircularQueue {

    private int[] array;
    private int front;
    private int rear;

    public CircularQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enqueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }

        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int dequeue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空！");
        }

        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    public void output() {
        for(int i = front; i!=rear; i=(i+1)%array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(6);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(9);
        queue.output();
    }
}
