package com.xht.dsa.ds;

/**
 * Created by xht on 2020/2/6
 * <p>
 * 稀疏数组
 * <p>
 * 编写的五子棋程序中，有存盘退出和续上盘的功能。
 * <p>
 * 可以使用二维数组记录棋盘
 * <p>
 * 如果二维数组中很多都是默认值0的情况下，可以转为稀疏数组
 * <p>
 * 二维数组===》稀疏数组
 * <p>
 * 稀疏数组===》二维数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        System.out.println("原始的二维数组：");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }


        //将二维数组转为稀疏数组
        //1、先遍历二维数组，得到非零数据的个数
        int sum = 0;

        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println();

        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];

        //给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非零的值存放到稀疏数组
        int rowNum = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[rowNum][0] = i;
                    sparseArr[rowNum][1] = j;
                    sparseArr[rowNum][2] = chessArr1[i][j];
                    rowNum++;
                }
            }
        }


        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }


        System.out.println();

        //将稀疏数组恢复成二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
        for (int i = 1; i < sparseArr.length; i++) {
            int row = sparseArr[i][0];
            int column = sparseArr[i][1];
            int value = sparseArr[i][2];

            chessArr2[row][column] = value;
        }


        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }
    }

}
