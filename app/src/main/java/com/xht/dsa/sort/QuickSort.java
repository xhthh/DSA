package com.xht.dsa.sort;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xht on 2020/2/13
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        sort(array, 0, array.length - 1);
//        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition3(array, startIndex, endIndex);
        sort(array, startIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 为什么从右边开始动
     * <p>
     * 如果选取最左边的数arr[left]作为基准数，那么先从右边开始可保证i,j在相遇时，
     * 相遇数是小于基准数的，交换之后temp所在位置的左边都小于temp。
     * 但先从左边开始,相遇数是大于基准数的，无法满足temp左边的数都小于它。
     * 所以进行扫描，要从基准数的对面开始。（注：左右相对来说，也可前后）
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && array[right] > pivot) {
                right--;
            }

            while (left < right && array[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    /**
     * 选取右边的为基准值，则两指针从左边开始动
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition2(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            while (left < right && array[left] < pivot) {
                left++;
            }

            while (left < right && array[right] >= pivot) {
                right--;
            }


            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[endIndex] = array[right];
        array[right] = pivot;

        return right;
    }


    /**
     * 单边循环
     *
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int partition3(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivot;

        return mark;
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //用一个集合来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();

        //整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();

        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        //循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            //栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition3(arr, param.get("startIndex"), param.get("endIndex"));
            //根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

}
