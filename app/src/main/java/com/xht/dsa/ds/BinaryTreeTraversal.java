package com.xht.dsa.ds;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by xht on 2020/2/11
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.
                asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println(" 前序遍历：");

        preOrderTraveral(treeNode);
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }

        return node;
    }

    public static void preOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }


    static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }

}
