package com.xht.dsa.arithmetic.divide;


public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 6, 9, 10, 23, 34, 55};

        int index = binarySearch(arr, 9);

        System.out.println("index==" + index);

        int index2 = search(arr, 9, 0, arr.length - 1);
        System.out.println("index2==" + index2);
    }


    //循环
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    //递归法
    public static int search(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (key < arr[mid]) {
            return search(arr, key, low, mid - 1);
        } else if (key > arr[mid]) {
            return search(arr, key, mid + 1, high);
        } else {
            return mid;
        }
    }

}
