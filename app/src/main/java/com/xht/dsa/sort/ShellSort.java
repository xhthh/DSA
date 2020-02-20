package com.xht.dsa.sort;

import java.util.Arrays;

/**
 * Created by xht on 2020/2/18
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};

        //        System.out.println(Arrays.toString(shellSort(arr)));
        //
        //        System.out.println(Arrays.toString(sort(arr)));
        //
        System.out.println(Arrays.toString(sort2(arr)));
        //
        //        System.out.println(Arrays.toString(sort3(arr)));

        //        System.out.println(Arrays.toString(sort4(arr)));

        System.out.println(Arrays.toString(sort5(arr)));
    }

    private static int[] shellSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;

                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        return arr;
    }


    public static int[] sort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        //增量每次都/2
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - step >= 0 && arr[j - step] > temp) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = temp;
            }
        }

        return arr;
    }

    public static int[] sort3(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        //1, 3, 2, 6, 5, 7, 8, 9, 10, 0     10个元素，step 初始值为 10/2=5
        //1,             7
        //   3,             8
        //      2,             9
        //         6,             10
        //            5,              0//变换位置

        //1, 3, 2, 6, 0, 7, 8, 9, 10, 5
        //1,    2
        //   3,    6
        //      2,    0//位置2和位置4比较，比完交换，再和位置0比较
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        int temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }

        return arr;
    }

    public static int[] sort2(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);

        int h = 1;
        while (h < arr.length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
            h = h / 3;
        }

        return arr;
    }

    /**
     * 重点记忆
     * @param sourceArr
     * @return
     */
    public static int[] sort5(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);


        for (int h = arr.length / 2; h > 0; h /= 2) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
        }

        return arr;
    }
}
