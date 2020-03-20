package com.xht.dsa.arithmetic;

/**
 * Created by xht on 2020/2/21
 * <p>
 * greatest common divisor
 * <p>
 * 最大公约数
 * <p>
 * 欧几里得算法：
 * 两个正整数a和b（a>b），他们的最大公约数等于a除以b的余数c和b之间的最大公约数。
 */
public class GCD {

    public static void main(String[] args) {

        System.out.println("最大公约数=" + getGreatestCommonDivisor(255, 10));
        System.out.println("最大公约数=" + getGreatestCommonDivisor2(255, 10));
    }

    /*
        辗转相除法，使用递归

        首先，计算出a除以b的余数c，把问题转化成求b和c的最大公约数；
        然后计算出b除以c的余数d，把问题转化成求c和d的最大公约数；
        再计算出c除以d的余数e，把问题转化成求d和e的最大公约数……
        以此类推，逐渐把两个较大整数之间的运算简化成两个较小整数之间的运算，
        直到两个数可以整除，或者其中一个数减小到1为止。

        问题：当两个整数较大时，做 a%b 取模运算的性能会较差
     */
    private static int getGreatestCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        if (big % small == 0) {
            return small;
        }

        return getGreatestCommonDivisor(small, big % small);
    }

    /*
        更相减损术--《九章算术》
        两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数。

        更相减损术是不稳定的算法，当两数相差悬殊时，如计算10000和1的最大公约数，就要递归9999次！
     */
    private static int getGreatestCommonDivisor2(int a, int b) {
        if (a == b) {
            return a;
        }

        int big = a > b ? a : b;
        int small = a < b ? a : b;

        return getGreatestCommonDivisor2(big - small, small);
    }

    /*
    奈何语琴
        当a和b均为偶数时，gcd(a,b) = 2×gcd(a/2, b/2) = 2×gcd(a>>1,b>>1)。
        当a为偶数，b为奇数时，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)。
        当a为奇数，b为偶数时，gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)。
        当a和b均为奇数时，先利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b)，此
        时a-b必然是偶数，然后又可以继续进行移位运算。

        按位与 &
        运算规则：0&0=0;   0&1=0;    1&0=0;     1&1=1;
        即：两位同时为“1”，结果才为“1”，否则为0
     */
    private static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }

        if ((a & 1) == 0 && (b & 1) == 0) {//都是偶数
            //即a的二机制最后一位是0，0&1=0
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {//a是偶数，b是奇数
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {//a是奇数，b是偶数
            return gcd(a, b >> 1);
        } else {//均为奇数
            int big = a > b ? a : b;
            int small = a < b ? a : b;

            int diff = big - small;

            return gcd(diff, small);
        }
    }
}
