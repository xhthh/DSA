package com.xht.dsa.arithmetic.RecursiveCall;

public class Test1 {


    public static void main(String[] args) {
        int[] value = new int[]{1, 5, 10, 50, 100};

        int sum = sum(2, value);

        System.out.println("sum==" + sum);

    }


    //数组求和
    public static int sum(int i, int[] arr) {
        if (i < arr.length - 1) {
            return arr[i] + sum(i + 1, arr);
        } else {
            return arr[i];
        }

    }

    //一个人爬楼梯，每次只能爬1个或2个台阶，假设有n个台阶，那么这个人有多少种不同的爬楼梯方法？
    int f(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }


}
