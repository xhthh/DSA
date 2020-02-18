package com.xht.dsa.ds;

import java.util.Arrays;

/**
 * Created by xht on 2020/2/12
 */
public class PriorityQueue {

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue(3);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(10);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(7);

        System.out.println(Arrays.toString(priorityQueue.array) + "\n");

        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(Arrays.toString(priorityQueue.array));
    }

    public int[] array;
    private int size;

    public PriorityQueue() {
        array = new int[8];
    }

    private void enqueue(int key) {
        if (size > array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("the queue is empty!");
        }

        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    private void downAdjust() {
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;

        while (childIndex < size) {
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (temp >= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;

        int temp = array[childIndex];

        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];

            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    private void resize() {
        int newSize = 2 * size;
        this.array = Arrays.copyOf(this.array, newSize);
    }

}
