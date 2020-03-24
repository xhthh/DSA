package com.xht.dsa.arithmetic.divide;

public class Hanoi {

    public static void main(String[] args) {

        hanoi(2, "A", "B", "C");

    }

    public static void hanoi(int n, String sourceTower, String tempTower, String targetTower) {
        if (n == 1) {
            //如果只有一个盘子1，那么直接将其从sourceTower移动到targetTower
            move(n, sourceTower, targetTower);
        } else {
            //将（盘子n-1~盘子1）由sourceTower经过targetTower移动到tempTower
            hanoi(n - 1, sourceTower, targetTower, tempTower);
            //移动盘子n由sourceTower移动到targetTower
            move(n, sourceTower, targetTower);
            //把之前移动到tempTower的（盘子n-1~盘子1），由tempTower经过sourceTower移动到targetTower
            hanoi(n - 1, tempTower, sourceTower, targetTower);
        }
    }

    //盘子n的从sourceTower-->targetTower的移动
    private static void move(int n, String sourceTower, String targetTower) {
        System.out.println("第" + n + "号盘子 move：" + sourceTower + "--->" + targetTower);
    }


}
