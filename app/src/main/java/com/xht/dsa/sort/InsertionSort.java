package com.xht.dsa.sort;

import java.util.Arrays;

/**
 * Created by xht on 2020/2/18
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};

        insertionSort(arr);
//
//        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        //从下标为1 的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            //记录要插入的数据
            int temp = arr[i];

            //从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];//如果要插入的数据比前边的小，前边的数据往后移
                j--;//记录最后一个比要插入的数据小的数的位置
            }

            //存在比其小的数，插入
            if (j != i) {
                arr[j] = temp;
            }
        }
    }

    /**
     * 记这个吧
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }


}
