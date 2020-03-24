package com.xht.dsa.arithmetic.DynamicProgramming;

/**
 * 爬台阶
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class Test2 {

    public static void main(String[] args) {

        System.out.println("f(5)=" + f(5));

        System.out.println(climbStairs(5));
    }

    /*
        自顶向下递归

        可以根据第一步的走法把所有走法分为两类：

        ① 第一类是第一步走了 1 个台阶
        ② 第二类是第一步走了 2 个台阶

        所以 n 个台阶的走法就等于先走 1 阶后，n-1 个台阶的走法 ，然后加上先走 2 阶后，n-2 个台阶的走法。

        用公式表示就是：
        f(n) = f(n-1)+f(n-2)
     */
    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }

    /*
        自底向上循环

        只需要保存前两位的状态
    */
    public static int f2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // a 保存倒数第二个子状态数据，b 保存倒数第一个子状态数据， temp 保存当前状态的数据
        int a = 1, b = 2, temp = a + b;

        for(int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];//多开一位，考虑起始位置

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
