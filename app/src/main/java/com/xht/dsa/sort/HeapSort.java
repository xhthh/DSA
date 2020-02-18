package com.xht.dsa.sort;

import java.util.Arrays;

/**
 * Created by xht on 2020/2/18
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序（升序）
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        //1、把无序数组构建成最大堆
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, arr.length);
        }

        System.out.println(Arrays.toString(arr));

        //循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            downAdjust(arr, 0, i);
        }
    }

    public static void downAdjust(int[] arr, int parentIndex, int length) {
        //保存父节点值，用于最后的赋值
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }

            //如果父节点大于任何一个孩子的值，则直接跳出
            if (temp >= arr[childIndex]) {
                break;
            }

            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * parentIndex + 1;
        }
        arr[parentIndex] = temp;
    }

}
