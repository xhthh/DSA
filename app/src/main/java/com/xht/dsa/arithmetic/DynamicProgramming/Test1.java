package com.xht.dsa.arithmetic.DynamicProgramming;

/**
 * 金矿问题
 */
public class Test1 {

    public static void main(String[] args) {

        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};

        //int num = getBestGoldMining(w, p.length, p, g);

        //int num = getBestGoldMiningV2(w, p, g);
        int num = getBestGoldMiningV3(w, p, g);


        System.out.println("最大采金量==" + num);

    }

    /**
     * 所谓动态规划，就是把复杂的问题简化成规模较小的子问题，再从简单的子问题自底向上一步一步递推，
     * 最终得到复杂问题的最优解。
     * <p>
     * 动态规划的要点：确定全局最优解和最优子结构之间的关系，以及问题的边界。
     * 这个关系用数学公式来表达的话，就叫作状态转移方程式。
     *
     * @param w 工人数量
     * @param n 可选金矿数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     * @return 最后一个一定挖 or 最后一个一定不挖
     * <p>
     * 状态转移方程式如下:
     * F(n,w) = 0 (n=0或w=0)
     * 问题边界，金矿数为0或工人数为0的情况。
     * <p>
     * F(n,w) = F(n-1,w) (n≥1, w<p[n-1])
     * 当所剩工人不够挖掘当前金矿时，只有一种最优子结构。
     * <p>
     * F(n,w) = max(F(n-1,w), F(n-1,w-p[n-1])+g[n-1]) (n≥1,w≥p[n-1])
     * 在常规情况下，具有两种最优子结构（挖当前金矿或不挖当前金矿）。
     */
    public static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        if (w == 0 || n == 0) {
            return 0;
        }

        //当所剩工人不够挖掘当前金矿时，只有一种最优子结构。
        if (w < p[n - 1]) {
            return getBestGoldMining(w, n - 1, p, g);
        }

        //在常规情况下，具有两种最优子结构（挖当前金矿或不挖当前金矿）
        return Math.max(getBestGoldMining(w, n - 1, p, g),
                getBestGoldMining(w - p[n - 1], n - 1, p, g) + g[n - 1]);
    }

    /**
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     */
    public static int getBestGoldMiningV2(int w, int[] p, int[] g) {
        //创建表格
        int[][] resultTable = new int[g.length + 1][w + 1];

        //填充表格
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    resultTable[i][j] = Math.max(resultTable[i - 1][j],
                            resultTable[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }

        //返回最后1个格子的值
        return resultTable[g.length][w];
    }

    /**
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     *          <p>
     *          以4个金矿9个工人为例
     *          4个金矿、9个工人的最优结果，是由它的两个最优子结构，也就是3个金矿、5
     *          个工人和3个金矿、9个工人的结果推导而来的。
     *          即第四座金矿挖不挖
     *          <p>
     *          <p>
     *          所以，在程序中并不需要保存整个表格，无论金矿有多少座，我们只保存1行的
     *          数据即可。
     */
    public static int getBestGoldMiningV3(int w, int[] p, int[] g) {
        //创建当前结果
        int[] results = new int[w + 1];

        //填充一维数组
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    results[j] = Math.max(results[j],
                            results[j - p[i - 1]] + g[i - 1]);
                }
            }
        }

        //返回最后1个格子的值
        return results[w];
    }

}
