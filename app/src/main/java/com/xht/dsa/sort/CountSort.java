package com.xht.dsa.sort;

import java.util.Arrays;

/**
 * Created by xht on 2020/2/20
 */
public class CountSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = countSort2(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        //1、得到数列的最大值
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //2、根据数列最大值确定统计数组的长度，加1是因为从0开始
        //比如最大值为10，则需要统计数组长度为0~10，11个位置
        int[] countArray = new int[max + 1];


        //3、遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }

        //4、遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }


        return sortedArray;
    }

    private static int[] countSort2(int[] array) {
        //1、得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        int d = max - min;

        //2、创建统计数组并统计对应元素的个数
        int[] countArray = new int[d + 1];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        System.out.println("统计数组    " + Arrays.toString(countArray));

        //3、统计数组做变形，后面的元素等于前面的元素之和

        /*
            目的是让统计数组存储的元素值，等于相应整数的最终排序位置的序号。

            原数组{95, 94, 91, 98, 99, 90, 99, 93, 91, 92}
            最小 90   最大 99

            比如统计数组[1, 2, 1, 1, 1, 1, 0, 0, 1, 2] 已经是有序的，表示 90的 有一个，91的有两个，92的有一个。。。
            后面的元素等于前面的元素之和，变形后：
            变形后的数组[1, 3, 4, 5, 6, 7, 7, 7, 8, 10]

            从后向前遍历，92-90=2  2-1=1 统计数组位置1 值为3，即92占排序后的数组第三位
            [1, 3, 3, 5, 6, 7, 7, 7, 8, 10]



            统计数组2   [1, 3, 3, 5, 6, 7, 7, 7, 8, 10]
            排列数组    [0, 0, 0, 92, 0, 0, 0, 0, 0, 0]

            统计数组2   [1, 2, 3, 5, 6, 7, 7, 7, 8, 10]
            排列数组    [0, 0, 91, 92, 0, 0, 0, 0, 0, 0]

            统计数组2   [1, 2, 3, 4, 6, 7, 7, 7, 8, 10]
            排列数组    [0, 0, 91, 92, 93, 0, 0, 0, 0, 0]

            统计数组2   [1, 2, 3, 4, 6, 7, 7, 7, 8, 9]
            排列数组    [0, 0, 91, 92, 93, 0, 0, 0, 0, 99]

            统计数组2   [0, 2, 3, 4, 6, 7, 7, 7, 8, 9]
            排列数组    [90, 0, 91, 92, 93, 0, 0, 0, 0, 99]

            统计数组2   [0, 2, 3, 4, 6, 7, 7, 7, 8, 8]
            排列数组    [90, 0, 91, 92, 93, 0, 0, 0, 99, 99]

            统计数组2   [0, 2, 3, 4, 6, 7, 7, 7, 7, 8]
            排列数组    [90, 0, 91, 92, 93, 0, 0, 98, 99, 99]

            统计数组2   [0, 1, 3, 4, 6, 7, 7, 7, 7, 8]
            排列数组    [90, 91, 91, 92, 93, 0, 0, 98, 99, 99]

            统计数组2   [0, 1, 3, 4, 5, 7, 7, 7, 7, 8]
            排列数组    [90, 91, 91, 92, 93, 94, 0, 98, 99, 99]

            统计数组2   [0, 1, 3, 4, 5, 6, 7, 7, 7, 8]
            排列数组    [90, 91, 91, 92, 93, 94, 95, 98, 99, 99]

            [90, 91, 91, 92, 93, 94, 95, 98, 99, 99]
         */
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        System.out.println("统计数组变形 " + Arrays.toString(countArray));

        //4、倒序遍历原始数列，从统计数组找到正确的位置，输出到结果数组
        int[] sortedArray = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];//此处-1，是将1~n的排名放到0~n-1的数组中去，为什么
            countArray[array[i] - min]--;

            System.out.println();
            System.out.println("统计数组2 " + Arrays.toString(countArray));
            System.out.println("排列数组 " + Arrays.toString(sortedArray));
            System.out.println();
        }

        return sortedArray;
    }

}
