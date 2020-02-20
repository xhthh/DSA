package com.xht.dsa.sort;

import java.util.Arrays;

/**
 * Created by xht on 2020/2/19
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};

        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 归并排序
     * <p>
     * 自顶向下的归并排序
     * <p>
     * 要将一个数组排序，可以先递归将它分成两半分别排序，然后将结果归并起来。
     *
     * @param array
     * @param low
     * @param high
     */
    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    /**
     * 创建一个适当大小的数组然后将两个输入数组中的元素一个个从小到大放入这个数组。
     *
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[array.length];
        int left = low;
        int right = mid + 1;
        int k = low;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp[k++] = array[left++];
            } else {
                temp[k++] = array[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = array[left++];
        }

        while (right <= high) {
            temp[k++] = array[right++];
        }

        for (int i = low; i <= high; i++) {
            array[i] = temp[i];
        }
    }

    private static void merge2(int[] array, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (array[left] < array[right]) {
                temp[k++] = array[left++];
            } else {
                temp[k++] = array[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = array[left++];
        }

        while (right <= high) {
            temp[k++] = array[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            array[i + low] = temp[i];
        }

    }

}

